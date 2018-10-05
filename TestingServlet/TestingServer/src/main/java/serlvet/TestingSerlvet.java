package serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestingSerlvet
 */
public class TestingSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestingSerlvet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
    //response.addHeader("Access-Control-Allow-Origin", "*");
		String uri = request.getRequestURI();
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		if (uri.equals("/TestingServer/go")) {
        response.getWriter().append("{\"mainData\":\"testingOne\"}");
		}
		else if (uri.equals("/TestingServer/tableGet")) {
			response.getWriter().append("[{\"testName\":\"test1\",\"testResult\":\"passed\"},{\"testName\":\"test2\",\"testResult\":\"if you can see this it passed\"}]");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
