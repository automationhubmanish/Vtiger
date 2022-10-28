package com.evs.vtiger.testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer{

	private int count =0;
	private static int maxTry=3;
	@Override
	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess()) {
			if(count<maxTry) {
				count++;
				result.setStatus(ITestResult.FAILURE);
				return true;
			}else {
				 result.setStatus(ITestResult.SKIP);
			}
		}else {
			result.setStatus(ITestResult.SUCCESS);
		}
		
		
		
		
		return false;
	}

}
