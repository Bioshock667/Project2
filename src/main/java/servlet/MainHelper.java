package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import model.Employee;
import model.ReimbRequest;
import service.MainService;
import org.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
public class MainHelper {
	final public static Logger logger;
	
	static {
		System.setProperty("log4j.configurationFile","src/main/resources/configuration.xml");
		logger = LogManager.getLogger(MainHelper.class);
		System.out.println("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));
		System.setProperty("log4j2.debug", "true");
	}
	public static boolean hasSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("info") != null;
	}
	public static void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("incoming request  GET " + request.getRequestURI());
		if(request.getRequestURI().equals("/Project1/MainServlet/isloggedin")) {
			response.getWriter().append(Boolean.toString(hasSession(request, response)));
			return;
		}
		if(!hasSession(request, response)) {
			sendUnauthorized(request, response);
			return;
		}
		try {
			if(request.getRequestURI().matches("/Project1/MainServlet/\\d*\\.jpg")) {
				getImage(request, response);
			}
			switch(request.getRequestURI()) {
			case "/Project1/MainServlet/home":
				response.getWriter().append("home");
				break;
			case "/Project1/MainServlet/getAllEmployees":
				getAllEmployees(request, response);
				break;
			case "/Project1/MainServlet/getRequests":
				getRequests(false, request, response);
				break;
			case "/Project1/MainServlet/getAllRequests":
				getRequests(true, request, response);
				break;
			case "/Project1/MainServlet/approveRequest":
				approveRequest(request, response);
				break;
			case "/Project1/MainServlet/denyRequest":
				denyRequest(request, response);
				break;
			case "/Project1/MainServlet/getMyAccount":
				getAccount(false, request, response);
				break;
			case "/Project1/MainServlet/getImage":
				getImage(request, response);
				break;
			case "/Project1/MainServlet/getReqStats":
				getReqStats(request, response);
				break;
			case "/Project1/MainServlet/getManagerStats":
				getManagerStats(request, response);
				break;
			case "/Project1/MainServlet/logout":
				logout(request, response);
				break;
			}
		}catch (SQLException e) {
			logger.catching(e);
			sendServerError(response, e.getMessage());
		}
	}

	public static void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("incoming request  POST " + request.getRequestURI());
		try {
		if(request.getRequestURI().equals("/Project1/MainServlet/login"))
			login(request, response);
		else if(!hasSession(request, response)) {
			sendUnauthorized(request,response);
			return;
		}
		
		if(request.getRequestURI().equals("/Project1/MainServlet/submitRequest")) {
			submitRequest(request, response);
		} else if (request.getRequestURI().equals("/Project1/MainServlet/updateUser")) {
			changeAccount(request, response);
		}
		} catch (Exception e) {
			logger.catching(e);
			sendServerError(response, e.getMessage());
		}
		
	}
	
	private static void getAllEmployees(HttpServletRequest request, HttpServletResponse response) throws  IOException, SQLException{
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request, response);
			return;
		}
		Employee emp = (Employee) session.getAttribute("info");
		if(emp == null) {
			sendUnauthorized(request, response);
			return;
		}
		if(!emp.isManager()) {
			logger.warn("{} attempted unauthorized access", emp.getUserName());
			sendForbidden(emp.getUserName(), request, response);
			return;
		}
		
		ArrayList<Employee> emps = MainService.getEmployees();
		ArrayList<JSONObject> jos = new ArrayList<>();
		if(emps == null)
			return;
		for(Employee e : emps) {
			if(e != null)
				jos.add(EtoJSON(e));
		}
		logger.info("User {} has retrieved all employee info", emp.getUserName());
		response.getWriter().append(jos.toString());
	}
	
	public static void getRequests(boolean getAll, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request, response);
			return;
		}
		Employee emp = (Employee) session.getAttribute("info");
		if(emp == null) {
			sendUnauthorized(request, response);
			return;
		}
		if(getAll && !emp.isManager()) {
			sendForbidden(emp.getUserName(), request, response);
			return;
		}
			String field = request.getParameter("field");
			String value = request.getParameter("value");
			String limit = request.getParameter("limit");
			ArrayList<ReimbRequest> rrs;
			
			if(getAll) {
				logger.info("User {} is getting all requests with field {}, value {}, limit {}", field, value, limit);
			} else {
				logger.info("User {} is getting his/her requests with field {}, value {}, limit {}", field, value, limit);
			}
			//either both field and value are null or both are not null
			if(field == null || value == null) {
				if(getAll)
					rrs = MainService.getAllRRs(null, null, limit);
				else
					rrs = MainService.getRRsbyId(emp.getId(), null, null, limit);
			}
			else {
				if(getAll)
					rrs = MainService.getAllRRs(field, value, limit);
				else
					rrs = MainService.getRRsbyId(emp.getId(), field, value, limit);
			}
			ArrayList<JSONObject> jos = new ArrayList<>();
			for(ReimbRequest r : rrs) {
				
				jos.add(RRtoJSON(r));
			}
			response.getWriter().append(jos.toString());
		
	}
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException  {
		String body = request.getReader().readLine();
		try {
			JSONObject jo;
			jo = new JSONObject(body);
		
			String name = jo.getString("username");
			String password = jo.getString("password");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(password.getBytes());
			String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			Employee user = MainService.login(name, myHash);
			
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("info", user);
				Cookie type;
				if(user.isManager())
					type = new Cookie("type", "manager");
				else
					type = new Cookie("type", "employee");
				type.setPath("/Project1");
				response.addCookie(type);
				logger.info("User {} has successfully logged in", user.getUserName());
				response.getWriter().append("success");
			}
			else {
				logger.info("unsuccessful login");
				response.getWriter().append("unsuccessful");
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
			sendServerError(response, e.getMessage());
		} catch (JSONException e1) {
			logger.error(e1);
			sendServerError(response, e1.getMessage());
		}
	}

	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
			logger.info("user has logged out");
			response.getWriter().append("logout successful");
		}
	}
	
	public static void submitRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request, response);
			return;
		}
		Employee user = (Employee) session.getAttribute("info");
		if(user == null) {
			sendUnauthorized(request,response);
			return;
		}
		String samount = new BufferedReader(new InputStreamReader(
				request.getPart("amount").getInputStream(), "utf-8")).readLine();
		Double amount = Double.parseDouble(samount);
		String reason = new BufferedReader(new InputStreamReader(
				request.getPart("reason").getInputStream(), "utf-8")).readLine();
		Part part = request.getPart("file");
		InputStream pictureStream = null;
		if (part != null)
			pictureStream = part.getInputStream();
		String log_message = " User {} has submitted a request for ${} with reason: {} with" + (pictureStream == null?" no":"") + " picture";
		logger.debug(log_message, user.getUserName(), amount, reason);
		MainService.submitReq(user.getId(), amount, reason, pictureStream);
	}
	public static void approveRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request, response);
			return;
		}
		Employee user = (Employee) session.getAttribute("info");
		if(user == null) {
			sendUnauthorized(request, response);
			return;
		}
		if(!user.isManager()) {
			sendForbidden(user.getUserName(), request, response);
			return;
		}
		String id = request.getParameter("id");
		if(id != null) {
			int rr_id = Integer.parseInt(id);
			MainService.approveReq(rr_id, user.getId());
			logger.info("Manager {} {} has APPROVED request {}.", user.getFirstName(), user.getLastName(), rr_id);
		}
	}
	
	public static void denyRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}
		Employee user = (Employee) session.getAttribute("info");
		if(user == null) {
			return;
		}
		if(!user.isManager()) {
			sendForbidden(user.getUserName(), request, response);
			return;
		}
		int rr_id = Integer.parseInt( request.getParameter("id"));
		String reason = request.getParameter("reason");
		logger.info("Manager {} {} has REJECTED request {} for reason: {}.", user.getFirstName(), user.getLastName(), rr_id, reason);
		MainService.denyReq(rr_id, user.getId(), reason);
	}
	
	public static void changeAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request, response);
			return;
		}
		Employee user = (Employee) session.getAttribute("info");
		if(user == null) {
			sendUnauthorized(request, response);
			return;
		}
		String body = request.getReader().readLine();
		JSONObject jo = new JSONObject(body);
		Employee newCreds = JSONtoE(jo, user.isManager());
		
		if(newCreds.getPassword() != null) {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(newCreds.getPassword().getBytes());
			String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			newCreds.setPassword(myHash);
		}
		MainService.updateEmployee(newCreds);
		if(newCreds.getPassword() != null) {
			logout(request, response);
		} else {
			session.setAttribute("info", newCreds);
		}
		if(newCreds.getPassword() != null) {
			logger.info("User {} has changed his/her password", newCreds.getUserName());
		}
		if(!user.equals(newCreds)) {
			logger.info("User has changed his/her info from {} to {}", user, newCreds);
		}
	}
	
	public static void getAccount(boolean getAll, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request,response);
			return;
		}
		Employee user = (Employee) session.getAttribute("info");
		if(user == null) {
			sendUnauthorized(request, response);
			return;
		}
		JSONObject jo = EtoJSON(user);
		response.getWriter().append(jo.toString());
	}
	
	public static void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String imageId = request.getParameter("id");
		logger.trace("Client requests picture for request {}", imageId);
		int id = Integer.parseInt(imageId);
		InputStream pictureInput = MainService.getImage(id);
		if(pictureInput != null) {
			int c = pictureInput.read();
			while(c != -1) {
			response.getWriter().write(c);
			c = pictureInput.read();
			}
			response.getWriter().flush();
		}
	}

	private static void getManagerStats(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request, response);
			return;
		}
		Employee emp = (Employee) session.getAttribute("info");
		if(emp == null) {
			sendUnauthorized(request, response);
			return;
		}
		if(!emp.isManager()) {
			sendForbidden(emp.getUserName(), request, response);
			return;
		}
		Map<String, Integer> stats = MainService.getManagerStats();
		ArrayList<JSONObject> json = new ArrayList<>();
		for(String s: stats.keySet()) 
			json.add(new JSONObject().put("name", s).put("amountResolved", stats.get(s)));
		ManStatesComparator m = new MainHelper.ManStatesComparator();
		json.sort(m);
		int rank = 1;
		for(JSONObject j : json) {
			j.put("rank", rank);
			rank += 1;
		}
		response.getWriter().println(json);
	}
	public static class ManStatesComparator implements Comparator<JSONObject> {

		@Override
		public int compare(JSONObject arg0, JSONObject arg1) {
			int arg0Val = arg0.getInt("amountResolved");
			int arg1Val = arg1.getInt("amountResolved");
			return arg1Val - arg0Val;
		}
	}
	private static void getReqStats(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			sendUnauthorized(request, response);
			return;
		}
		Employee emp = (Employee) session.getAttribute("info");
		if(emp == null) {
			sendUnauthorized(request, response);
			return;
		}
		if(!emp.isManager()) {
			sendForbidden(emp.getUserName(), request, response);
			return;
		}
		Map<String, Integer> stats = MainService.getReqStats();
		ArrayList<JSONObject> json = new ArrayList<>();
		for(String s: stats.keySet()) {
			json.add(new JSONObject().put("label", s).put("value", stats.get(s)));
		}
		response.getWriter().println(json);
	}
	
	public static void sendForbidden(String empName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.warn("{} attempted unauthorized access at {}", empName, request.getRequestURI());
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.getWriter().append("You do not have permission to do this.");
	}
	
	public static void sendUnauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.warn("Attempted unauthenticated access to {}", request.getRequestURI());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().append("unauthorized");
	}
	
		private static void sendServerError(HttpServletResponse response, String error_message) throws IOException {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.getWriter().append(error_message);
	}
		
	private static JSONObject RRtoJSON(ReimbRequest r) {
		return new JSONObject().put("id", r.getId())
		.put("status", r.getStatus())
		.put("amount", r.getAmount())
		.put("reason", r.getReason())
		.put("subName", r.getSubmitterName())
		.put("resName", r.getResolverName())
		.put("dateSub", r.getDateSubmitted().toString())
		.put("dateRes", (r.getDateResolved() == null?"":r.getDateResolved().toString()))
		.put("hasImage", r.hasImage());
	}
	
	private static JSONObject EtoJSON(Employee user) {
		return new JSONObject().put("id", user.getId()).put("firstName", user.getFirstName()).put("lastName", user.getLastName())
			.put("password", user.getPassword()).put("userName", user.getUserName());
	}
	
	private static Employee JSONtoE(JSONObject jo, boolean isManager) {
		Object p = jo.get("password");
		String pass = null;
		if(!p.equals(null)) {
			pass = (String)p;
		}
		return new Employee(jo.getInt("id"), jo.getString("userName"), pass, jo.getString("firstName")
				, jo.getString("lastName") , isManager);
	}
}
