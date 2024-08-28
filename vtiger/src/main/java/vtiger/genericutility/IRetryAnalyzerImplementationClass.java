package vtiger.genericutility;

import org.testng.IRetryAnalyzer;
//synchronisation issue ko deal karne le liye class banate hai
import org.testng.ITestResult;

public class IRetryAnalyzerImplementationClass implements IRetryAnalyzer {
	int count = 0;
	int limit = 2;
	
	public boolean retry(ITestResult result) {
		
		while(count<=limit) {
			count++;
			return true;
		}
		
		return false;

}
}