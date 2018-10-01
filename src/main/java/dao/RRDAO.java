package dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.StringJoiner;

import model.ReimbRequest;
import model.Status;
import util.JDBConnection;

/*CREATE TABLE r_requests (
    rr_id NUMBER(10) PRIMARY KEY,
    emp_id NUMBER(10),
    amount DECIMAL(10,2),
    status CHAR(10),
    resolver_id NUMBER(10),
    date_submitted TIMESTAMP,
    date_resolved TIMESTAMP,
    reason VARCHAR2(80),
    rejection_reason VARCHAR2(80),
    CONSTRAINT FK_RR_SUBMITTER_ID FOREIGN KEY (emp_id) REFERENCES employees(emp_id) ON DELETE CASCADE
    );
    */
public class RRDAO implements DAO<ReimbRequest> {

	public void create(ReimbRequest entry) throws SQLException {
		Connection conn = JDBConnection.getConnection();
		String sql = "insert into r_requests values(rr_id_generator.nextval, ?, ?, ?, null, current_timestamp, null, ?, null, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, entry.getEmpID());
		ps.setDouble(2, entry.getAmount());
		ps.setString(3, entry.getStatus().toString());
		ps.setString(4, entry.getReason());
		if(entry.getPictureBuffer() != null)
			ps.setBinaryStream(5, entry.getPictureBuffer());
		else
			ps.setNull(5, Types.BLOB);
		ps.executeUpdate();
		ps.close();
	}

	public ReimbRequest get(int id) throws SQLException {
		Connection conn = JDBConnection.getConnection();
		String sql = "    select sub_query.*, employees.first_name || ' ' || employees.last_name as submitter_name from" + 
				"    ( select r.*," + 
				"        (case when e.first_name is null and e.last_name is null " +
				" 			then null  else  e.first_name || ' ' || e.last_name end)  as resolver_name" + 
				"        from r_requests r left join employees e on r.resolver_id=e.emp_id where r.rr_id = ?" + 
				"    ) sub_query" + 
				"    join employees on sub_query.emp_id=employees.emp_id;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet result = ps.executeQuery();
		if(result.next()) {
			int emp_id = result.getInt("emp_id");
			double amount = result.getDouble("amount");
			Status status = Status.valueOf(result.getString("status"));
			Integer resolver_id = result.getInt("resolver_id");
			if (resolver_id == 0) {
				resolver_id = null;
			}
			Timestamp date_submitted = result.getTimestamp("date_submitted");
			Timestamp date_resolved = result.getTimestamp("date_resolved");
			String submitterName = result.getString("submitter_name");
			String resolverName = result.getString("resolver_name");
			String reason = result.getString("reason");
			String r_reason = result.getString("rejection_reason");
			Blob blob = result.getBlob("picture");
			
			return new ReimbRequest(id,emp_id, amount, status, submitterName, resolver_id, 
					resolverName, date_submitted, date_resolved, reason, r_reason, null, blob != null);
		}
		else
			return null;
	}

	public void update(ReimbRequest newEntry) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void approve(int rr_id, int resolverId) throws SQLException {
		Connection conn = JDBConnection.getConnection();
		CallableStatement cs = conn.prepareCall("{ call approve_request(?,?) }");
		cs.setInt(1, rr_id);
		cs.setInt(2, resolverId);
		cs.executeUpdate();
	}
	public void deny(int rr_id, int resolverId, String reason) throws SQLException {
		Connection conn = JDBConnection.getConnection();
		CallableStatement cs = conn.prepareCall("{ call deny_request(?,?,?) }");
		cs.setInt(1, rr_id);
		cs.setInt(2, resolverId);
		cs.setString(3, reason);
		cs.executeUpdate();
	}
	public void delete(int id) throws SQLException {
		Connection conn = JDBConnection.getConnection();
		String sql = "delete from r_requests where rr_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	public ArrayList<ReimbRequest> getRRs(Integer id, String filterField, String filterValue, 
			String orderByField, String limit) throws SQLException {
		
		String[] searchCols = {"amount","date_resolved","date_submitted","emp_id",
				"resolver_id","status"};
		Integer filterInt = null;
		Double filterDouble = null;
		String filterString = null;
		Timestamp filterTime = null;
		if(filterField != null) {
			boolean found = false;
			for(String s : searchCols) {
				if(filterField.equals(s)) {
					found = true;
					break;
				}
			}
		
			if(!found)
				throw new IllegalArgumentException("Invalid filter field "+filterField+"\n The legal arguments are: " + String.join(", ", searchCols));
			
			if(filterField.equals(searchCols[0])) { //amount
				filterDouble = Double.parseDouble(filterValue);
			} else if (filterField.equals(searchCols[3]) || filterField.equals(searchCols[4])) { //emp_id or resolver_id
				filterInt = Integer.parseInt(filterValue);
			} else if (filterField.equals(searchCols[1]) || filterField.equals(searchCols[2])) { //date_res or date_sub
				filterTime = Timestamp.valueOf(filterValue);
			} else if (filterField.equals(searchCols[5])) { //status
				filterString = filterValue;
			}
		}
		if (limit != null) {
			try {
				Integer.parseInt(limit);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				throw new IllegalArgumentException("Limit must be an integer not " + limit);
			}
		}
		ArrayList<ReimbRequest> RRs = new ArrayList<ReimbRequest>();
		Connection conn = JDBConnection.getConnection();
		
		String s = "    select sub_query.*, employees.first_name || ' ' || employees.last_name as submitter_name from" + 
				"    ( select r.*," + 
				"        (case when e.first_name is null and e.last_name is null " +
				" 			then null  else  e.first_name || ' ' || e.last_name end)  as resolver_name" + 
				"        from r_requests r left join employees e on r.resolver_id=e.emp_id" + 
				"    ) sub_query" + 
				"    join employees on sub_query.emp_id=employees.emp_id";
		
		StringBuilder sb = new StringBuilder(s);
		//if we have any restrictions add a where clause
		if(id != null || (filterField != null && filterValue != null)) {
			sb.append(" where ");
			StringJoiner joiner = new StringJoiner(" and ");
			if(id != null) {
				joiner.add("sub_query.emp_id = ?");
			}
			if(filterField != null && filterValue != null)
				joiner.add("sub_query." + filterField + " = ?");
			sb.append(joiner);
		}
		if(orderByField != null) {
			sb.append(" order by " + orderByField);
		}
		if(limit != null)
			sb.append(" offset 0 rows fetch next " + limit + " rows only");
		String sql = sb.toString();
		PreparedStatement ps = conn.prepareStatement(sql);
		int index = 1;
		if(id != null) {
			ps.setInt(index, id);
			index += 1;
		}
		if(filterField != null && filterValue != null) {
			if(filterInt != null)
				ps.setInt(index, filterInt);
			else if (filterDouble != null) 
				ps.setDouble(index, filterDouble);
			else if (filterTime != null)
				ps.setTimestamp(index, filterTime);
			else if (filterString != null)
				ps.setString(index, filterString);
			index += 1;
		}
		
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			int rr_id = result.getInt("rr_id");
			int emp_id = result.getInt("emp_id");
			double amount = result.getDouble("amount");
			Status status = Status.valueOf(result.getString("status"));
			Timestamp date_submitted = result.getTimestamp("date_submitted");
			Timestamp date_resolved = result.getTimestamp("date_resolved");
			String submitterName = result.getString("submitter_name");
			String resolverName = result.getString("resolver_name");
			Integer resolver_id = result.getInt("resolver_id");
			if (resolver_id == 0) {
				resolver_id = null;
			}
			String reason = result.getString("reason");
			String r_reason = result.getString("rejection_reason");
			Blob blob = result.getBlob("picture");
			RRs.add( new ReimbRequest(rr_id, emp_id, amount, status, submitterName, resolver_id,
					resolverName, date_submitted, date_resolved, reason, r_reason, null, blob != null));
		}
		return RRs;
	}
	
	public InputStream getImage(int id) throws SQLException {
		Connection conn = JDBConnection.getConnection();
		String sql = "select picture from r_requests where rr_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			Blob b = res.getBlob(1);
			if(b != null)
				return b.getBinaryStream();
			else
				return null;
		}
		else
			return null;
	}
	
}
