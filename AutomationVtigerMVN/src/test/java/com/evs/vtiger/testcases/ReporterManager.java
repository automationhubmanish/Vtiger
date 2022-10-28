package com.evs.vtiger.testcases;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class ReporterManager implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		for(ISuite suite:suites) {
			
			System.out.println("Suite name - "+suite.getName());
			
			Map<String , ISuiteResult> results =suite.getResults();
			
			for(ISuiteResult suiteResult:results.values()) {
			ITestContext  testContext =	suiteResult.getTestContext();
			
			Reporter.log("Test tag name - "+testContext.getName()+" "+"Test start date -"
			+testContext.getStartDate()+" "+" Test end date - "+" "+testContext.getEndDate()+" test report output directory is - "+testContext.getOutputDirectory() );
			
			System.out.println("Test tag name - "+testContext.getName()+" "+"Test start date -"
			+testContext.getStartDate()+" "+" Test end date - "+" "+testContext.getEndDate()+" test report output directory is - "+testContext.getOutputDirectory());
			
		Collection<ITestNGMethod> failedMethod =	testContext.getFailedTests().getAllMethods();
			Reporter.log("Total failed method count is -"+failedMethod.size());
			
			System.out.println("Total failed method count is -"+failedMethod.size());
			
			for(ITestNGMethod tm:failedMethod) {
				Reporter.log(tm.getMethodName()+" "+tm.getDescription());
				System.out.println(tm.getMethodName()+" "+tm.getDescription());
				
			}
			Reporter.log("Passed test method count - "+testContext.getPassedTests().size());
			
			System.out.println("Passed test method count - "+testContext.getPassedTests().size());
			
			
			Reporter.log("Skipped test method count - "+testContext.getSkippedTests().size());
			
			System.out.println("Skipped test method count - "+testContext.getSkippedTests().size());
			
			
			}
		}
		
		
	Reporter.log("Output html report path is -"+outputDirectory);
		
	System.out.println("Output html report path is -"+outputDirectory);
		
	}



}
