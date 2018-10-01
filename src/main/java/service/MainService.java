package service;
import java.io.InputStream;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.EmployeeDAO;
import dao.RRDAO;
import model.*;

public class MainService {
	private static EmployeeDAO eDAO = new EmployeeDAO();
	private static RRDAO rrDAO = new RRDAO();

	public static void createEmployee(Employee e) throws SQLException {
		eDAO.create(e);
	}
	
	public static void submitReq(int emp_id, double amount, String reason, InputStream pictureBuf) throws SQLException {
		rrDAO.create(new ReimbRequest(0,emp_id, amount, Status.PENDING, null, null, null, null, null, reason, null, pictureBuf, false));
	}
	
	public static Employee login(String username, String password) throws SQLException {
		return eDAO.validate(username, password);
	}
	
	public static ArrayList<Employee> getEmployees() throws SQLException {
		return eDAO.getAllEmployees();
	}
	
	public static Employee getEmployee(int id) throws SQLException {
		return eDAO.get(id);
	}
	
	public static ArrayList<ReimbRequest> getAllRRs(String filterField, String filterValue, String limit) throws SQLException {
		return rrDAO.getRRs(null, filterField, filterValue, null, limit);
	}
	
	public static ArrayList<ReimbRequest> getRRsbyId(int id, String filterField, String filterValue, String limit) throws SQLException {
		return rrDAO.getRRs(id, filterField, filterValue, null, limit);
	}
	
	public static ReimbRequest getRR(int id) throws SQLException {
		return rrDAO.get(id);
	}
	
	public static void updateEmployee(Employee e) throws SQLException {
		eDAO.update(e);
	}
	
	public static void approveReq(int rr_id, int resolver_id) throws SQLException {
		rrDAO.approve(rr_id, resolver_id);
	}
	
	public static void denyReq(int rr_id, int resolver_id, String reason) throws SQLException {
		rrDAO.deny(rr_id, resolver_id, reason);
	}
	
	public static void deleteEmployee(int id) throws SQLException {
		eDAO.delete(id);
	}
	
	public static void deleteReq(int id) throws SQLException {
		rrDAO.delete(id);
	}
	
	public static InputStream getImage(int id) throws SQLException {
		return rrDAO.getImage(id);
	}
	public static Map<String, Integer> getReqStats() throws SQLException {
		ArrayList<ReimbRequest> prrs = rrDAO.getRRs(null, "status", "PENDING", null , null);
		ArrayList<ReimbRequest> arrs = rrDAO.getRRs(null, "status", "APPROVED", null , null);
		ArrayList<ReimbRequest> rrrs = rrDAO.getRRs(null, "status", "REJECTED", null , null);
		Map<String, Integer> stats = new HashMap<String, Integer>();
		stats.put("PENDING", prrs.size());
		stats.put("APPROVED", arrs.size());
		stats.put("REJECTED", rrrs.size());
		return stats;
	}
	
	public static Map<String, Integer> getManagerStats() throws SQLException {
		ArrayList<Employee> emps = eDAO.getAllEmployees();
		ArrayList<ReimbRequest> rrs = rrDAO.getRRs(null, null, null, null, null);
		Map<String, Integer> stats = new HashMap<String, Integer>();
		for(Employee e : emps) {
			if(e.isManager())
				stats.put(e.getFirstName()+" "+e.getLastName(), 0);
		}
		for(ReimbRequest r : rrs) {
			String resolver = r.getResolverName();
			if(resolver != null) {
				if(stats.containsKey(resolver)) {
					Integer oldval = stats.get(resolver);
					stats.replace(resolver, oldval + 1);
				} 
			}
		}
		return stats;
	}
}
