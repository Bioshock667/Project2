package serlvet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		} else if (uri.equals("/TestingServer/loginCuke")) {
			runTestNG("cuketest.xml", response);
		} else if (uri.equals("/TestingServer/homePage")) {
			runTestNG("hometestng.xml", response);
		} else if (uri.equals("/TestingServer/colorFace")) {
			runTestNG("colorcuke.xml", response);
		} else if (uri.equals("/TestingServer/auditTest")) {
			runTestNG("auditcuketest.xml", response);
		} else if (uri.equals("/TestingServer/protractor")) {
			runProtractor(response);
			//response.getWriter().println("Todo: implement Protractor");
		} else if (uri.equals("/TestingServer/BAYearsTest")) {
			runTestNG("AsBaYears.xml", response);
		}
	}

	private void runProtractor(HttpServletResponse response) {
		Runtime r = Runtime.getRuntime();
		try {
			Process protractor = r.exec(new String[] {"cmd", " /c", "C:\\Users\\Administrator\\AppData\\Roaming\\npm\\protractor", "C:\\Users\\Administrator\\Documents\\protractor\\conf.js"});
			InputStream input = protractor.getInputStream();
			InputStream err = protractor.getErrorStream();
			String s = null;
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(input));
				BufferedReader e = new BufferedReader(
						new InputStreamReader(err));
				
				while ((s = br.readLine()) != null) {
					response.getWriter().println(s);
				}
				while((s = e.readLine()) != null) {
					response.getWriter().println("Error: " + s);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void runTestNG(String testxml, HttpServletResponse response) throws IOException {
		TestNG tng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("../webapps/TestingServer/WEB-INF/classes/" + testxml);
		tng.setTestSuites(suites);
		tng.run();
		
		response.getWriter().append("[");
		List<ITestListener> il = tng.getTestListeners();
		GenericTestListener tResult = null;
		StringBuilder sb = new StringBuilder();
		for (ITestListener i : il) {
			if (i instanceof GenericTestListener) tResult = (GenericTestListener)i;
		}
		if (tResult != null) {
			
			for (ITestResult t: tResult.getPassed()) {
				sb.append("{\"testName\":\""+t.getName()+"\",\"testResult\":\"PASSED\"},");
			}
			
			for (ITestResult t: tResult.getFailed()) {
				sb.append("{\"testName\":\""+t.getName()+"\",\"testResult\":\"FAILED\"},");
			}
		}
		String s = sb.substring(0, sb.length()-1);
		response.getWriter().append(s);
		response.getWriter().append("]");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
