package consoleTest;
import cucumber.api.cli.*;

public class TestCallCucumber {
	
	public static void main(String[] args) throws Throwable {
		Main.main(new String[] {"-g","--glue C:/git_repos/Project2/TestingServlet/TestingServer/target/classes/tests/CucumberTest","/git_repos/Project2/TestingServlet/TestingServer/src/main/java/cuctest.feature"});
	}

}
