package listeners;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GenericTestListener implements ITestListener {

	private List<ITestResult> passed,failed,skipped;
	
	public GenericTestListener () {
		passed = new ArrayList<ITestResult>();
		failed = new ArrayList<ITestResult>();
		skipped = new ArrayList<ITestResult>();
	}
	
	public List<ITestResult> getPassed() {
		return passed;
	}
	public List<ITestResult> getFailed() {
		return failed;
	}
	public List<ITestResult> getSkipped() {
		return skipped;
	}
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		passed.add(result);
		
	}

	public void onTestFailure(ITestResult result) {
		failed.add(result);
		
	}

	public void onTestSkipped(ITestResult result) {
		skipped.add(result);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
