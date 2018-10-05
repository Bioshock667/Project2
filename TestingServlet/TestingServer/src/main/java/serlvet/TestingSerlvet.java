package serlvet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;

import listeners.GenericTestListener;


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
		else if (uri.equals("/TestingServer/navBar")) {
			TestNG tng = new TestNG();
			List<String> suites = new ArrayList<String>();
			
			suites.add("../webapps/TestingServer/WEB-INF/classes/testng.xml");
			
			tng.setTestSuites(suites);
			tng.run();
			
			response.getWriter().append("[");
			List<ITestListener> il = tng.getTestListeners();
			GenericTestListener tResult = null;
			for (ITestListener i : il) {
				if (i instanceof GenericTestListener) tResult = (GenericTestListener)i;
			}
			if (tResult != null) {
				
				for (ITestResult t: tResult.getPassed()) {
					response.getWriter().append("{\"testName\":\""+t.getName()+"\",\"testResult\":\"PASSED\"}");
				}
				
				for (ITestResult t: tResult.getFailed()) {
					response.getWriter().append("{\"testName\":\""+t.getName()+"\",\"testResult\":\"FAILED\"}");
				}
			}
			
			response.getWriter().append("]");
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
