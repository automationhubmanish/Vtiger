package com.evs.vtiger.testcases;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;
import com.evs.vtiger.exceldata.ExcelDataUtil;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.login.LoginPage;
import com.evs.vtiger.utility.WdUtil;

public class BaseTest {

	protected WdUtil webUtil;
	protected ExcelDataUtil excelData;
	protected List<Map<String, String>> dataMapList;

	@BeforeSuite
	public void tearUp() {
		webUtil = new WdUtil();
		webUtil.initHtmlReport();
	}

	@BeforeClass(alwaysRun = true)
	public void beforeTestCaseClass() throws IOException {
		excelData = new ExcelDataUtil();
	}

	@AfterClass
	public void afterTestCaseClass() {
		webUtil.close();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeTestCase(Method tm) throws IOException {
		String tmName = tm.getName();
		webUtil.setExtentLogger(tmName);
		String brName =webUtil.getPropObj().getProperty("BrowserName");
		webUtil.launchBrowser(brName);
		LoginPage loginPage = new LoginPage(webUtil);
		loginPage.validLogin();
	}

	
	@AfterMethod
	public void afterTestCase(ITestResult tr, Method tm) throws IOException {
		String tmName = tm.getName();
		if (tr.getStatus() == ITestResult.FAILURE) {
			webUtil.getExtentLogger().addScreenCaptureFromPath(webUtil.getScreenShot(tmName));
			webUtil.getExtentLogger().log(Status.FAIL, tmName + " is failed ");
		} else if (tr.getStatus() == ITestResult.SUCCESS) {
			webUtil.getExtentLogger().log(Status.PASS, tmName + " is passed ");
		} else {
			webUtil.getExtentLogger().log(Status.SKIP, tmName + " is skipped ");
		}
		new HomePage(webUtil).logOut();
		webUtil.flushReport();
	}

	@AfterSuite
	public void tearDown() {
		webUtil.flushReport();
	}
}
