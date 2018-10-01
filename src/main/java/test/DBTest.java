package test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import util.JDBConnection;
public class DBTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = JDBConnection.getConnection();
		String sql = "{ exec submit_requests(0, 1000, 'i want money') }";
		CallableStatement cs = conn.prepareCall(sql);
		cs.executeQuery();
		int val = cs.getInt(1);
		System.out.println(val);
	}

}
