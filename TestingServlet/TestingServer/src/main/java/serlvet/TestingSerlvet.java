package serlvet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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
		} else if (uri.equals("/TestingServer/managebatchtest")) {
			runTestNG("managebatchtesting.xml", response);
		}
	}

	private void runProtractor(HttpServletResponse response) {
		Runtime r = Runtime.getRuntime();
		System.out.println("Protractor test is running");
		try {
			Process protractor = r.exec(new String[] {"cmd", " /c", "C:\\Users\\Administrator\\AppData\\Roaming\\npm\\protractor", "C:\\Users\\Administrator\\Documents\\protractor\\conf.js"});
			//Process protractor = r.exec(new String[] {"cmd", " /c", "C:\\Users\\jaffa\\AppData\\Roaming\\npm\\protractor", "C:\\Users\\jaffa\\Documents\\protractor-test\\conf.js"});
			InputStream input = protractor.getInputStream();
			InputStream err = protractor.getErrorStream();
			String s = null;
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
				BufferedReader br = new BufferedReader(
						new InputStreamReader(input, "utf-8"));
				BufferedReader e = new BufferedReader(
						new InputStreamReader(err, "utf-8"));
				//do not pay attention to the following mumbo jumbo.  Removing terminal color sequences and knowing which lines are test results
				// is not easy
				boolean firstSuite = true;
				boolean first = true;
				StringJoiner tests = new StringJoiner(",");
				while ((s = br.readLine()) != null) {
					boolean passed = s.contains("[32m.[0m");
					boolean failed = s.contains("[31mF[0m");
					if(passed || failed) {
						if (firstSuite) {
							s = br.readLine();
							firstSuite = false;
						}
						if(first) {
							tests.add("{\"testName\":\"" + s.replace("[32m.[0m", "") + "\",\"testResult\":\"Suite\"}");
							s = br.readLine();	
							first = false;
						}
						String test = "{\"testName\":\"" + s.replace("[32m.[0m", "").replace("[39m", "")
						.replace("[31mF[0m", "").replace("[31m", "").replace("[32m", "") + "\",";
						if(passed) {
							test += "\"testResult\":\"PASSED\"}";
						} else if (failed) {
							test += "\"testResult\":\"FAILED\"}";
						} else {
							test += "\"testResult\":\"Unknown\"}";
						}
						tests.add(test);
					} else if (!first) {
						first = true;
					}
					System.out.println(s);
					
				}
				response.getWriter().append("[" + tests.toString() + "]");
				StringBuilder errorMessage = new StringBuilder();
				while((s = e.readLine()) != null) {
					errorMessage.append(s);
				}
				if (errorMessage.length() > 0) {
					response.getWriter().append("{\"testName\":\"" + errorMessage + "\", \"testResult\":\"Error\"}");
				}
				System.out.println("Protractor is finished");
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
