package com.evs.vtiger.testcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.evs.vtiger.utility.WdUtil;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase started execution and details are - "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase execution success and details are - "+result.getStatus());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase execution is failed and details are - "+result.getStatus());
//		WdUtil util =	new WdUtil();
//		util.getScreenShot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase execution skipped and details are - "+result.getStatus());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Your Testcase execution starting - "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Your Testcase execution finised - "+context.getName());
	}

}
