package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count=0;
	int retrycount= 3; //Manual analysis
	public boolean retry(ITestResult result) {
		//0<3 1<3 2<3 3<NOT3-FALSE
		while(count<retrycount)
		{
			count++; // 1 2 3 
			return true; //retry retry retry
		}
		
		return false; // stop retrying
	}

}
