 package vtiger.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;
public class ItestListenersImplemantationClass implements ITestListener{
//how  can we generate automatic abstract method
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailure(ITestResult result) {
		result.getMethod().getMethodName();
	//how can we generate automatic exception
		try {
			WebDriverUtility.takesScreenShot(BaseClass.sDriver, "testCaseName");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	
}