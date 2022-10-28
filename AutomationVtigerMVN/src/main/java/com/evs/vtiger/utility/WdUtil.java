package com.evs.vtiger.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class WdUtil {

	private ExtentReports extentReportObj;
	private ExtentTest extentTestObj;
	private WebDriver driver;
	private Properties propObj;

	/* It is a constructor. In which I am creating object of FileInputStream because i want to   
	 * read data from config.properties. Because i want when i create object of WebUtil then it 
	 * will already initialize of propObj.
	 */

	public WdUtil() {
		try {
			InputStream fs = new FileInputStream("src\\test\\resources\\config.properties");
			propObj = new Properties();
			propObj.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 *  It a getter method of ExtentLogger.
	 */
	public ExtentTest getExtentLogger() {
		return extentTestObj;
	}
	/* Here I am created method for launching any browser with the conditions and with the  
	 * better report.
	 */
	public WebDriver launchBrowser(String Browser) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
			getExtentLogger().log(Status.INFO, "Chrome Browser launched successfully ");
			driver.manage().window().maximize();
			getExtentLogger().log(Status.INFO, "Window maximize successfully ");
		} else if (Browser.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browser\\geckodriver.exe");
			driver = new FirefoxDriver();
			getExtentLogger().log(Status.INFO, "FireFox Browser launched successfully ");
			driver.manage().window().maximize();
			extentTestObj.log(Status.INFO, "Window maximize successfully ");
		} else if (Browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "src\\main\\resources\\Browser\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			extentTestObj.log(Status.INFO, "InternetExplorer Browser launched successfully ");
			driver.manage().window().maximize();
			extentTestObj.log(Status.INFO, "Window maximize successfully ");
		} else {
			System.out.println(Browser + " Browser name is wrong . Please chacke it - ");
			extentTestObj.log(Status.INFO, Browser + " Browser name is wrong . Please chacke it - ");
		}
		return driver;
	}

	/*
	 *  It is use for navigate URL
	 */
	public void openURL(String url) {
		driver.get(url);
		extentTestObj.log(Status.INFO, "URL hitted successfully ");

	} 
	/* It is a getter method of WebDriver
	 */
	public WebDriver getDriver() {
		return driver;

	}
	/*
	 * It is a getter method of Properties.
	 */
	public Properties getPropObj() {
		return propObj;
	}
	/* It is method for getting screenshot.
	 *  When it will tack screenshot of any file then it will save in 
	 *  given file name.
	 */ 
	public String getScreenShot(String method) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File to = tss.getScreenshotAs(OutputType.FILE);
		File from = new File("ScreenShot/"  +method+ getCurrentTime() + ".png");
		try {
			Files.copy(to, from);
		} catch (IOException e) {

		}
		return from.getAbsolutePath();
	}
//	It will get current time in the format of current system.

	public String getCurrentTime() {
		SimpleDateFormat smpDatTime = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		Date dtObj = new Date();
		String date = smpDatTime.format(dtObj);
		return date;
	}

	///////////// Windows ////////////////

	public void maximizeWindow() {
		driver.manage().window().maximize();
		System.out.println("Windows Maximize successefully : ");
		extentTestObj.log(Status.INFO, "Windows Maximize successefully : ");

	}

	public void refreshWindow() {
		driver.navigate().refresh();
		System.out.println("Page Refresh successefully : ");
		extentTestObj.log(Status.INFO, "Page Refresh successefully : ");

	}
	/* It will close all the window because in which i used quit method.
	 */
	public void close() {
		driver.close();
		driver.quit();
		System.out.println("Current Windows clossed succesefully :");
		extentTestObj.log(Status.INFO, "Current Windows clossed succesefully :");

	}

	public void quit() {
		driver.quit();
		System.out.println("Current Windows quit succesefully :");
		extentTestObj.log(Status.INFO, "Current Windows quit succesefully :");
	}

	/////////////// Random Number or Random Option ///////////

	public  int selectRandomNumber(int minNum, int maxNum) {
		int randNum = (int) (Math.random() * (maxNum - minNum + 1) + minNum);
		System.out.println(randNum);
		return randNum;
	}

	public  List<WebElement> selectRandomOption(WebElement weVariable) {
		Select sct = new Select(weVariable);
		List<WebElement> opt = sct.getOptions();
		for(int i=0;i<=opt.size();i++) {
		WebElement we= opt.get(i);
		}
		opt.size();
		return opt;
	}

	////////////////// WebElement ////////////////////////

	public void click(WebElement we) {
		if (we.isDisplayed() & we.getSize().getHeight() == 0 & we.getSize().getWidth() == 0) {
			if (we.isEnabled()) {
				we.click();
				extentTestObj.log(Status.INFO, "Click performed succesefully :");
				System.out.println(" Element is clicked by WebElement ");
			} else
				extentTestObj.log(Status.INFO, "Click not performed successefully becouse element is not visible:");
			System.out.println(" Element is not Visible");
		} else
			extentTestObj.log(Status.INFO, "Click not performed successefully becouse element is not enabled :");
		System.out.println(" Element is not clicked ");
	}

	public void input(WebElement we, String inputvalue) {
		we.clear();
		if (we.isEnabled()) {
			if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
				we.sendKeys(inputvalue);
				extentTestObj.log(Status.INFO, "Value inputed succesefully by WebElement :");
				System.out.println("value input successfully by WebElement ");
			} else
				extentTestObj.log(Status.INFO, "Value is not input successefully becouse element is not Displayed:");
			System.out.println("Element is not Displayed ");
		} else
			extentTestObj.log(Status.INFO, "Value is not input successefully becouse element is not Enabled :");
		System.out.println("Element is not input ");
	}

	public int getHight(WebElement we, String elementname) {
		int hig = 0;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				hig = we.getSize().getHeight();
				extentTestObj.log(Status.INFO, elementname + " Element hight is : " + hig);
				System.out.println(elementname + " Element hight is : " + hig);
			} else
				extentTestObj.log(Status.INFO, elementname + " Element is not visible ");
			System.out.println(elementname + " Element is not visible");
		} else
			extentTestObj.log(Status.INFO, elementname + " Element is not displayed");
		System.out.println(elementname + " Element is not displayed");

		return hig;
	}

	public int getWidth(WebElement we, String elementname) {
		int wid = 0;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				wid = we.getSize().getWidth();
				extentTestObj.log(Status.INFO, elementname + " Element Width is : " + wid);
				System.out.println(elementname + " Element Width is : " + wid);
			} else
				extentTestObj.log(Status.INFO, elementname + " Element is  not visible");
			System.out.println(elementname + " Element is  not visible");
		} else
			extentTestObj.log(Status.INFO, elementname + " Element is not displayed");
		System.out.println(elementname + " Element is not displayed");
		return wid;
	}

	public int getXlocation(WebElement we, String elementname) {
		int x = 0;
		if (we.isEnabled()) {
			if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
				x = we.getLocation().getX();
				extentTestObj.log(Status.INFO, elementname + " Element location of X : " + x);
				System.out.println(elementname + " Element location of X : " + x);
			} else
				extentTestObj.log(Status.INFO, elementname + " Element is not display");
			System.out.println(elementname + " Element is not display");
		} else
			extentTestObj.log(Status.INFO, elementname + " Element is not Enable");
		System.out.println(elementname + " Element is not Enable");
		return x;
	}

	public int getYlocation(WebElement we, String elementname) {
		int y = 0;
		if (we.isEnabled()) {
			if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
				y = we.getLocation().getY();
				extentTestObj.log(Status.INFO, elementname + " Element location of Y :  " + y);
				System.out.println(elementname + " Element location of Y :  " + y);
			} else
				extentTestObj.log(Status.INFO, elementname + " Element is  not display");
			System.out.println(elementname + " Element is  not display");
		} else
			extentTestObj.log(Status.INFO, elementname + " Element is not showing on Enable");
		System.out.println(elementname + " Element is not showing on Enable");
		return y;
	}

	public String getInerText(WebElement we) {
		String text = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				text = we.getText();
				extentTestObj.log(Status.INFO, "InerText of Element : " + text);
				System.out.println("InerText of Element : " + text);
			} else
				extentTestObj.log(Status.INFO, "Element is not Enable");
			System.out.println("Element is not Enable");
		} else
			extentTestObj.log(Status.INFO, "Element is not displayed");
		System.out.println("Element is not displayed");
		return text;
	}

	public String getAtrbtText(WebElement we, String attributeName) {
		String attributeValue = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				attributeValue = we.getAttribute(attributeName);
				extentTestObj.log(Status.INFO, "InerText of Element : " + attributeValue);
				System.out.println("InerText of Element : " + attributeValue);
			} else
				extentTestObj.log(Status.INFO, "Element is not Enable");
			System.out.println("Element is not Enable");
		} else
			extentTestObj.log(Status.INFO, "Element is not displayed");
		System.out.println("Element is not displayed");
		return attributeValue;
	}

	public String getTagName(WebElement we, String elementname) {
		String tgn = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				tgn = we.getTagName();
				extentTestObj.log(Status.INFO, "TagName of " + elementname + " : " + tgn);
				System.out.println("TagName of " + elementname + " : " + tgn);
			} else
				extentTestObj.log(Status.INFO, "Element is not Enable");
			System.out.println("Element is not Enable");
		} else
			extentTestObj.log(Status.INFO, "Element of tagname is not Displayed ");
		System.out.println("Element of tagname is not Displayed ");
		return tgn;
	}

	///////////////////// DropDown ////////////////////

	public void selectByVisibleText(WebElement we, String Text) {
		Select se = new Select(we);

		if (we.isDisplayed()) {
			if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
				se.selectByVisibleText(Text);
				extentTestObj.log(Status.INFO, Text + " is selected by visibleText ");
				System.out.println(Text + " is selected by visibleText ");
			} else
				extentTestObj.log(Status.INFO, "DropDown Element is not enable : ");
			System.out.println("DropDown Element is not enable : ");
		} else {
			extentTestObj.log(Status.INFO, "DropDown Element is not Displayed : ");
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByIndex(WebElement we, int Number) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.selectByIndex(Number);
				extentTestObj.log(Status.INFO, Number + "Element is selected by index ");
				System.out.println(Number + "Element is selected by index ");
			} else {
				extentTestObj.log(Status.INFO, "DropDown Element is not enable : ");
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			extentTestObj.log(Status.INFO, "DropDown Element is not Displayed : ");
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByvalue(WebElement we, String value) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.selectByValue(value);
				extentTestObj.log(Status.INFO, value + "Element is selected by value ");
				System.out.println(value + "Element is selected by value ");
			} else {
				extentTestObj.log(Status.INFO, "DropDown Element is not enable : ");
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			extentTestObj.log(Status.INFO, "DropDown Element is not Displayed : ");
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void deselectByvalue(WebElement we, String deselectbyvalue) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.deselectByValue(deselectbyvalue);
				extentTestObj.log(Status.INFO, deselectbyvalue + "Element is deselected by value " + we.toString());
				System.out.println(deselectbyvalue + "Element is deselected by value ");
			} else {
				extentTestObj.log(Status.INFO, "DropDown Element is not enable : " + we.toString());
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			extentTestObj.log(Status.INFO, "DropDown Element is not Displayed : " + we.toString());
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void deselectByIndex(WebElement we, int deselectbyindex) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.deselectByIndex(deselectbyindex);
				extentTestObj.log(Status.INFO, deselectbyindex + "Element is deselected by index " + we.toString());
				System.out.println(deselectbyindex + "Element is deselected by index ");
			} else
				extentTestObj.log(Status.INFO, "DropDown Element is not enable : " + we.toString());
			System.out.println("DropDown Element is not enable : ");
		} else
			extentTestObj.log(Status.INFO, "DropDown Element is not Displayed : " + we.toString());
		System.out.println("DropDown Element is not Displayed : ");
	}

	public void deselectAll(WebElement we) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.deselectAll();
				extentTestObj.log(Status.INFO, " All Element is deselected  " + we.toString());
				System.out.println(" All Element is deselected  ");
			} else
				extentTestObj.log(Status.INFO, "DropDown Element is not enable : " + we.toString());
			System.out.println("DropDown Element is not enable : ");
		} else
			extentTestObj.log(Status.INFO, "DropDown Element is not Displayed : " + we.toString());
		System.out.println("DropDown Element is not Displayed : ");
	}

	public boolean selected(WebElement we) {
		boolean slc = we.isSelected();
		if (slc == true) {
			Reporter.log("Element is selected");
		} else {
			Assert.fail();
		}
		return slc;
	}

	public boolean displayed(WebElement we) {
		boolean displ = we.isDisplayed();
		System.out.println(we + " Element is displayed ");
		return displ;
	}

	public boolean enabled(WebElement we) {
		boolean enalb = we.isEnabled();
		System.out.println(we + " Element is Enabled ");
		return enalb;
	}

	//////////////////// Actions /////////////////

	public void actionMouseOver(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					extentTestObj.log(Status.INFO, "Element is moved by Actions : " + we.toString());
					System.out.println("Element is moved by Actions : ");
				}
			} else
				extentTestObj.log(Status.INFO, "Element is not Enable :" + we.toString());
			System.out.println("Element is not Enable :");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page" + we.toString());
		System.out.println("Element is not find on HTML Page");
	}

	public void actionClickAndHoldd(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			act.clickAndHold(we).build().perform();
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					extentTestObj.log(Status.INFO, " Element is clicked and hold by actions" + we.toString());
					System.out.println(" Element is clicked and hold by actions");
				} else
					extentTestObj.log(Status.INFO, " Element is not Enable :" + we.toString());
				System.out.println(" Element is not Enable :");
			} else
				extentTestObj.log(Status.INFO, "Element is not Display " + we.toString());
			System.out.println("Element is not Display ");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page" + we.toString());
		System.out.println("Element is not find on HTML Page");

	}

	public void actionInput(WebElement we, String inputDat) {
		Actions act = new Actions(driver);
		we.clear();
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.sendKeys(we, inputDat).build().perform();
					extentTestObj.log(Status.INFO, "Value input successfully by action" + we.toString());
					System.out.println("Value input successfully by action");
				} else
					extentTestObj.log(Status.INFO, "Element is not Enable :" + we.toString());
				System.out.println("Element is not Enable :");
			} else
				extentTestObj.log(Status.INFO, "Element is not display : " + we.toString());
			System.out.println("Element is not display : ");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page" + we.toString());
		System.out.println("Element is not find on HTML Page");
	}

	public void actionClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.click().build().perform();
					extentTestObj.log(Status.INFO, "Element is clicked by Actions " + we.toString());
					System.out.println("Element is clicked by Actions ");
				} else
					extentTestObj.log(Status.INFO, "Element is not Enable :" + we.toString());
				System.out.println("Element is not Enable :");
			} else
				extentTestObj.log(Status.INFO, "Element is not displayed : " + we.toString());
			System.out.println("Element is not displayed : ");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page" + we.toString());
		System.out.println("Element is not find on HTML Page");
	}

	public void actionDoudleClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.doubleClick(we).build().perform();
					extentTestObj.log(Status.INFO, "Double click on element is successfully " + we.toString());
					System.out.println("Double click on element is successfully ");
				} else
					extentTestObj.log(Status.INFO, "Element is not Enable :" + we.toString());
				System.out.println("Element is not Enable :");
			} else
				extentTestObj.log(Status.INFO, "Element is not displayed : " + we.toString());
			System.out.println("Element is not displayed : ");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page" + we.toString());
		System.out.println("Element is not find on HTML Page");
	}

	public void actionRightClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.contextClick(we).build().perform();
					extentTestObj.log(Status.INFO, "Right click on element is successfully" + we.toString());
					System.out.println("Right click on element is successfully");
				} else
					extentTestObj.log(Status.INFO, "Element is not Enable :" + we.toString());
				System.out.println("Element is not Enable :");
			} else
				extentTestObj.log(Status.INFO, "Element is not displayed : " + we.toString());
			System.out.println("Element is not displayed : ");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page" + we.toString());
		System.out.println("Element is not find on HTML Page");

	}

	public void actiondragAndDrop1(WebElement we1, WebElement ww2) {
		Actions act = new Actions(driver);
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0) {
			if (we1.isDisplayed()) {
				if (we1.isEnabled()) {
					act.dragAndDrop(we1, ww2).build().perform();
					extentTestObj.log(Status.INFO, "Element is drag and drop successfully by drag and drop ");
					System.out.println("Element is drag and drop successfully by drag and drop ");
				} else
					extentTestObj.log(Status.INFO, "Element is not Enable :");
				System.out.println("Element is not Enable :");
			} else
				extentTestObj.log(Status.INFO, "Element is not displayed : ");
			System.out.println("Element is not displayed : ");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page");
		System.out.println("Element is not find on HTML Page");
	}

	public void actiondragAndDrop2(WebElement we1, WebElement ww2) {
		Actions act = new Actions(driver);
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0) {
			if (we1.isDisplayed()) {
				if (we1.isEnabled()) {
					act.clickAndHold(we1).moveToElement(ww2).release().build().perform();
					extentTestObj.log(Status.INFO, "Element drag and drop and drop by move to element");
					System.out.println("Element drag and drop and drop by move to element");
				} else
					extentTestObj.log(Status.INFO, "Element is not Enable :");
				System.out.println("Element is not Enable :");
			} else
				extentTestObj.log(Status.INFO, "Element is not displayed : ");
			System.out.println("Element is not displayed : ");
		} else
			extentTestObj.log(Status.INFO, "Element is not find on HTML Page");
		System.out.println("Element is not find on HTML Page");
	}

	//////////////////////// JavaScript /////////////////////////

	public void jsClick(WebElement we) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", we);
		extentTestObj.log(Status.INFO, "Element is clicked by javascript " + we.toString());
		System.out.println("Element is clicked by javascript ");
	}

	public void jsSandkeys(WebElement we, String inputvalue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		we.clear();
		jse.executeScript("arguments[0].value=" + "'" + inputvalue + "'", we);
		extentTestObj.log(Status.INFO, "Value is inputed by javascript " + we.toString());
		System.out.println("Value is inputed by javascript ");
	}

	public void jsMouseOver(WebElement we) {

		String strJs = "var element = argument[0];" + "var mouseEventObj=document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";
		try {
			String mouseOverScript = "if(document.createEvent){var evObj =document.createEvent('MouseEvents');"
					+ "evObj.initEvent('mouseOver' ,true, false);arguments[0].dispatchEvent(evObj);}"
					+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(strJs, we);
		} catch (Exception e) {
			extentTestObj.log(Status.INFO, "javaScript MouseOver is not click " + we.toString());
			System.out.println("javaScript MouseOver is not click ");
		}
	}

	//////////////////////////// Wait /////////////////////////

	public void implicitWait(int timeInSecound) {

		driver.manage().timeouts().implicitlyWait(timeInSecound, TimeUnit.SECONDS);

	}

	public void staticWait(int timeInSecound) {
		int secound = timeInSecound * 1000;
		try {
			Thread.sleep(secound);
			extentTestObj.log(Status.INFO, "Static wait is puted ");
			System.out.println("Static wait is puted ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void enabledElementwait(WebElement we, int timeInSecound) {
		if (we.equals(we.isEnabled())) {
			WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
			expli.until(ExpectedConditions.elementToBeClickable(we));

		} else {
			extentTestObj.log(Status.INFO, "Element is not Enabled");
			System.out.println("Element is not Enabled");
		}
	}

	public void enabledTitleWait(String expTitle, int timeInSecound) {
		WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
		expli.until(ExpectedConditions.titleContains(expTitle));
	}

	public void selectedElementWait(WebElement we, int timeInSecound) {
		WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
		if (we.equals(we.isSelected())) {
			expli.until(ExpectedConditions.elementToBeSelected(we));
		} else {
			extentTestObj.log(Status.INFO, "Element is not selected");
			System.out.println("Element is not selected");
		}
	}

	public void visibleElementWait(WebElement we, int timeInSecound) {
		WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
		if (we.equals(we.isDisplayed())) {
			expli.until(ExpectedConditions.visibilityOfAllElements(we));
		} else {
			extentTestObj.log(Status.INFO, "Element is not visible");
			System.out.println("Element is not visible");
		}
	}

	/////////////////////// Alert //////////////////////

	public void popUpAccept(String expPopInerText) {
		String actualText = popUpGetText();
		if (actualText.contains(expPopInerText)) {
			extentTestObj.log(Status.INFO, "Actual text of popup -" + actualText);
			System.out.println(actualText);
			driver.switchTo().alert().accept();
			extentTestObj.log(Status.INFO, "Actual text is : " + actualText + " & Expected is : " + expPopInerText);
			Reporter.log("Actual text is : " + actualText + " & Expected is : " + expPopInerText);
			System.out.println(
					"Select data is deleted : Where actual is -" + actualText + "& Expecte is -" + expPopInerText);
		} else {
			Assert.fail();
			extentTestObj.log(Status.INFO, "PopUP is not accept . Becouse Actual text is - " + actualText
					+ " & Expected Text is -" + expPopInerText);
			System.out.println("PopUP is not accept . Becouse Actual text is - " + actualText + " & Expected Text is -"
					+ expPopInerText);
		}

	}

	public void popUpdismiss() {
		String actualText = popUpGetText();
		if (actualText.equalsIgnoreCase("")) {
			extentTestObj.log(Status.INFO, "Actual text of popup -" + actualText);
			System.out.println(actualText);
			driver.switchTo().alert().dismiss();
		} else {
			extentTestObj.log(Status.INFO, "PopUP is not accept . Becouse Actual text is - " + actualText);
			System.out
			.println("PopUP is not accept . Becouse Actual text is - " + actualText + " & Expected Text is -");
		}
	}

	public String popUpGetText() {

		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void popUpSendKeys(String inputvale) {

		driver.switchTo().alert().sendKeys(inputvale);

	}

	/////////////////////// iFrame /////////////////////////

	public WebDriver switchToFrameByIdOrName(String IdorNameValue) {
		WebDriver as = driver.switchTo().frame(IdorNameValue);
		return as;
	}

	public WebDriver switchToFrameByWebElement(WebElement we) {
		WebDriver ss = driver.switchTo().frame(we);
		return ss;
	}

	public WebDriver switchToFrameByIndex(int frameNumber) {
		WebDriver cd = driver.switchTo().frame(frameNumber);
		return cd;
	}

	public WebDriver switchToParentFrame() {
		WebDriver parentF = driver.switchTo().parentFrame();
		return parentF;
	}

	public WebDriver switchToMainFrame() {
		WebDriver mainf = driver.switchTo().defaultContent();
		return mainf;
	}

	///////////////////// Window Handle ////////////////

	public void switchToWindowsByTitle(String expTitle) {
		Set<String> window = driver.getWindowHandles();
		for (String multipleWindow : window) {
			driver.switchTo().window(multipleWindow);
			String tit = driver.getTitle();
			extentTestObj.log(Status.INFO, " Actual title is - " + tit);
			System.out.println(tit);
			if (tit.equalsIgnoreCase(expTitle)) {
				driver.switchTo().window(driver.getWindowHandle());
			}
		}

	}

	public void switchToWindowsByURL() {
		Set<String> window = driver.getWindowHandles();
		extentTestObj.log(Status.INFO, " Actual window is - " + window);
		System.out.println(window);
		for (String multipleWindow : window) {
			driver.switchTo().window(multipleWindow);
			String url = driver.getCurrentUrl();
			extentTestObj.log(Status.INFO, " Actual url is - " + url);
			System.out.println(url);
		}
		driver.switchTo().window(driver.getWindowHandle());
	}

	public String switchToWindowByURL(String expURl) {
		String window = driver.getWindowHandle();
		String actURl = driver.getCurrentUrl();
		extentTestObj.log(Status.INFO, " Actual url is - " + actURl);
		System.out.println(actURl);
		if (actURl.equalsIgnoreCase(expURl)) {
			driver.switchTo().window(window);
		}
		return window;
	}

	public String switchToMainWindowByTitle(String expTitle) {
		String window = driver.getWindowHandle();
		String actualTitle = driver.getTitle();
		extentTestObj.log(Status.INFO, " Actual Title is - " + actualTitle);
		System.out.println(actualTitle);
		if (actualTitle.equalsIgnoreCase(expTitle)) {
			driver.switchTo().window(window);
		}
		return window;
	}

	public WebElement keys(String keysname, WebElement we) {
		if (keysname.equalsIgnoreCase("F5")) {
			we.sendKeys(Keys.F5);
		} else if (keysname.equalsIgnoreCase("Enter")) {
			we.sendKeys(Keys.ENTER);
		} else if (keysname.equalsIgnoreCase("Arrow Down")) {
			we.sendKeys(Keys.ARROW_DOWN);
		} else if (keysname.equalsIgnoreCase("Arrow Up")) {
			we.sendKeys(Keys.ARROW_UP);
		} else if (keysname.equalsIgnoreCase("Arrow Left")) {
			we.sendKeys(Keys.ARROW_LEFT);
		} else if (keysname.equalsIgnoreCase("Arrow Right")) {
			we.sendKeys(Keys.ARROW_RIGHT);
		}

		return we;
	}

	/////////////// Methods of Verification //////////////

	public void waitForVisibiltyElement(WebElement we, int timeInSecond) {
		WebDriverWait webWait = new WebDriverWait(driver, timeInSecond);
		webWait.until(ExpectedConditions.visibilityOf(we));
	}

	public void verifyInnerText(WebElement we, String exptInnertext) {
		waitForVisibiltyElement(we, 15);

		String actualText = getInerText(we);
		if (actualText.equalsIgnoreCase(exptInnertext)) {
			extentTestObj.log(Status.INFO,
					"Verifycation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			Reporter.log("Verifycation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
		} else {
			extentTestObj.log(Status.INFO,
					"Verifycation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			System.out.println("Verifycation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualText, exptInnertext);
		}
	}

	public void verifyInnerTextContains(WebElement we, String exptInnertext) {
		String actualText = getInerText(we);
		if (actualText.contains(exptInnertext)) {
			extentTestObj.log(Status.INFO,
					"Verifycation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			Reporter.log("Verifycation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
		} else {
			extentTestObj.log(Status.INFO,
					"Verifycation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			System.out.println("Verifycation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualText, exptInnertext);
		}
	}

	public void verifyAttribute(WebElement we, String exptAttributeValue, String attributeName) {
		String actualAttributeValue = getAtrbtText(we, attributeName);
		if (actualAttributeValue.contains(exptAttributeValue)) {
			extentTestObj.log(Status.INFO, "Verifycation Passed. Where actual -" + actualAttributeValue
					+ " & Expected -" + exptAttributeValue);
			Reporter.log("Verifycation Passed. Where actual -" + actualAttributeValue + " & Expected -"
					+ exptAttributeValue);
		} else {
			extentTestObj.log(Status.INFO, "Verifycation Failed. Where actual -" + actualAttributeValue
					+ " & Expected -" + exptAttributeValue);
			System.out.println("Verifycation Failed. Where actual -" + actualAttributeValue + " & Expected -"
					+ exptAttributeValue);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualAttributeValue, exptAttributeValue);
		}
	}

	public void verifyElementIsEnabled(WebElement we) {
		boolean actualEnabled = enabled(we);
		if (actualEnabled == true) {
			extentTestObj.log(Status.INFO, "Verifycation Passed. Element is Enabled ");
			Reporter.log("Verifycation Passed. Element is Enabled ");
		} else {
			extentTestObj.log(Status.INFO, "Verifycation Passed. Element is Disabled ");
			System.out.println("Verifycation Passed. Element is Disabled ");
			Assert.fail();
		}
	}

	public void verifyElementIsSelected(WebElement we) {
		boolean actualChecked = selected(we);
		if (actualChecked == true) {
			extentTestObj.log(Status.INFO, "Verifycation Passed. Check box checked ");
			Reporter.log("Verifycation Passed. Check box checked ");

		} else {
			extentTestObj.log(Status.INFO, "Verifycation Passed. Check box unchecked ");
			System.out.println("Verifycation Passed. Check box unchecked ");
			Assert.fail();
		}
	}

	public void verifyUnChecked(WebElement we) {
		boolean actualChecked = selected(we);
		if (actualChecked == false) {
			extentTestObj.log(Status.INFO, "Verifycation Passed. Check box unchecked ");
			Reporter.log("Verifycation Passed. Check box unchecked ");

		} else {
			extentTestObj.log(Status.INFO, "Verifycation Passed. Check box checked ");
			System.out.println("Verifycation Passed. Check box checked ");
			Assert.fail();
		}
	}

	public String verifyTitle(String expTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expTitle)) {
			extentTestObj.log(Status.INFO, "Verifycation passed .Where actual Title is : " + actualTitle
					+ " & Expected title is : " + expTitle);
			System.out.println("Verifycation passed .Where actual Title is : " + actualTitle + " & Expected title is : "
					+ expTitle);
			Reporter.log("Verifycation Passed. Where actual -" + actualTitle + " & Expected -" + expTitle);

		} else {
			extentTestObj.log(Status.INFO, "Verifycation passed .Where actual Title is : " + actualTitle
					+ " & Expected title is : " + expTitle);
			System.out.println("Verifycation passed .Where actual Title is : " + actualTitle + " & Expected title is : "
					+ expTitle);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualTitle, expTitle);

		}
		return actualTitle;
	}

	public void verifyElementVisible(WebElement we) {
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			extentTestObj.log(Status.INFO, "Validation passed .Element is visible : ");
			System.out.println("Validation passed .Element is visible : ");
			Reporter.log("Verifycation passed .Element is visible : ");
		} else {
			extentTestObj.log(Status.INFO, "Verifycation passed .Element is invisible : ");
			System.out.println("Verifycation passed .Element is invisible : ");
			Assert.fail();
		}
	}

	public void verifyElementUnVisible(WebElement we) {
		if (!we.isDisplayed() & we.getSize().getHeight() == 0 & we.getSize().getWidth() == 0) {
			extentTestObj.log(Status.INFO, "Verifycation passed .Element is invisible : ");
			System.out.println("Verifycation passed .Element is invisible : ");
			Reporter.log("Verifycation passed .Element is invisible : ");

		} else {
			extentTestObj.log(Status.INFO, "Verifycation passed .Element is visible : ");
			System.out.println("Verifycation passed .Element is visible : ");
			Assert.fail();
		}
	}

	public void verifyCurrentUrl(String expUrl) {
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expUrl)) {
			extentTestObj.log(Status.INFO,
					"Verifycation Passed. Where actual -" + actualUrl + " & Expected -" + expUrl);
			Reporter.log("Verifycation Passed. Where actual -" + actualUrl + " & Expected -" + expUrl);
		} else {
			extentTestObj.log(Status.INFO,
					"VeriFication Field. Where actual url is :" + actualUrl + " & Expected url is :" + expUrl);
			System.out
			.println("VeriFication Field. Where actual url is :" + actualUrl + " & Expected url is :" + expUrl);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualUrl, expUrl);
		}
	}

	//////////////////////  Methods of Validation  /////////////////////

	public void validateInnerText(WebElement we, String exptInnertext) {
		String actualText = getInerText(we);
		if (actualText.equalsIgnoreCase(exptInnertext)) {
			extentTestObj.log(Status.INFO,
					"Validation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			Reporter.log("Validation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
		} else {
			extentTestObj.log(Status.INFO,
					"Validation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			System.out.println("Validation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			Assert.assertEquals(actualText, exptInnertext);
		}
	}

	public void validateInnerTextContains(WebElement we, String exptInnertext) {
		String actualText = getInerText(we);
		if (actualText.contains(exptInnertext)) {
			extentTestObj.log(Status.INFO,
					"Validation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			Reporter.log("Validation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
		} else {
			extentTestObj.log(Status.INFO,
					"Validation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			System.out.println("Validation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			Assert.assertEquals(actualText, exptInnertext);
		}
	}

	public void validateAttribute(WebElement we, String exptAttributeValue, String attributeName) {
		String actualAttributeValue = getAtrbtText(we, attributeName);
		if (actualAttributeValue.contains(exptAttributeValue)) {
			extentTestObj.log(Status.INFO,
					"Validation Passed. Where actual -" + actualAttributeValue + " & Expected -" + exptAttributeValue);
			Reporter.log(
					"Validation Passed. Where actual -" + actualAttributeValue + " & Expected -" + exptAttributeValue);

		} else {
			extentTestObj.log(Status.INFO,
					"Validation Failed. Where actual -" + actualAttributeValue + " & Expected -" + exptAttributeValue);
			System.out.println(
					"Validation Failed. Where actual -" + actualAttributeValue + " & Expected -" + exptAttributeValue);
			Assert.assertEquals(actualAttributeValue, exptAttributeValue);
		}
	}

	public void validateElementIsEnabled(WebElement we) {
		boolean actualEnabled = enabled(we);
		if (actualEnabled == true) {
			extentTestObj.log(Status.INFO, "Validation Passed. Element is Enabled ");
			Reporter.log("Validation Passed. Element is Enabled ");
		} else {
			extentTestObj.log(Status.INFO, "Validation Passed. Element is Disabled ");
			System.out.println("Validation Passed. Element is Disabled ");
			Assert.fail();
		}
	}

	public void validateElementIsSelected(WebElement we) {
		boolean actualChecked = selected(we);
		if (actualChecked == true) {
			extentTestObj.log(Status.INFO, "Validation Passed. Check box checked ");
			Reporter.log("Validation Passed. Check box checked ");

		} else {
			extentTestObj.log(Status.INFO, "Validation Passed. Check box unchecked ");
			System.out.println("Validation Passed. Check box unchecked ");
			Assert.fail();
		}
	}

	public void validateUnChecked(WebElement we) {
		boolean actualChecked = selected(we);
		if (actualChecked == false) {
			extentTestObj.log(Status.INFO, "Validation Passed. Check box unchecked ");
			Reporter.log("Validation Passed. Check box unchecked ");

		} else {
			extentTestObj.log(Status.INFO, "Validation Passed. Check box checked ");
			System.out.println("Validation Passed. Check box checked ");
			Assert.fail();
		}
	}

	public String validateTitle(String expTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expTitle)) {
			extentTestObj.log(Status.INFO,
					"Validation passed .Where actual Title is : " + actualTitle + " & Expected title is : " + expTitle);
			System.out.println(
					"Validation passed .Where actual Title is : " + actualTitle + " & Expected title is : " + expTitle);
			Reporter.log("Validation Passed. Where actual -" + actualTitle + " & Expected -" + expTitle);

		} else {
			extentTestObj.log(Status.INFO,
					"Validation passed .Where actual Title is : " + actualTitle + " & Expected title is : " + expTitle);
			System.out.println(
					"Validation passed .Where actual Title is : " + actualTitle + " & Expected title is : " + expTitle);
			Assert.assertEquals(actualTitle, expTitle);
		}
		return actualTitle;
	}

	public void validateElementVisible(WebElement we) {

		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			extentTestObj.log(Status.INFO, "Validation passed .Element is visible : ");
			System.out.println("Validation passed .Element is visible : ");
			Reporter.log("Validation passed .Element is visible : ");

		} else {
			extentTestObj.log(Status.INFO, "Validation passed .Element is invisible : ");
			System.out.println("Validation passed .Element is invisible : ");
			Assert.fail();
		}

	}

	public void validateElementUnVisible(WebElement we) {
		if (!we.isDisplayed() & we.getSize().getHeight() == 0 & we.getSize().getWidth() == 0) {
			extentTestObj.log(Status.INFO, "Validation passed .Element is invisible : ");
			System.out.println("Validation passed .Element is invisible : ");
			Reporter.log("Validation passed .Element is invisible : ");

		} else {
			extentTestObj.log(Status.INFO, "Validation passed .Element is visible : ");
			System.out.println("Validation passed .Element is visible : ");
			Assert.fail();
		}
	}

	public void validateCurrentUrl(String expUrl) {
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expUrl)) {
			extentTestObj.log(Status.INFO, "Validation passed .Element is visible : ");
			Reporter.log("Validation Passed. Where actual -" + actualUrl + " & Expected -" + expUrl);

		} else {
			extentTestObj.log(Status.INFO,
					"VeriFication Field. Where actual url is :" + actualUrl + " & Expected url is :" + expUrl);
			System.out
			.println("VeriFication Field. Where actual url is :" + actualUrl + " & Expected url is :" + expUrl);
			Assert.assertEquals(actualUrl, expUrl);
		}
	}

	//////////////// Extent Report code /////////////////

	public void initHtmlReport() {
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(
				"Report/" + " Extent Report " + getCurrentTime() + ".html");
		htmlReport.config().setDocumentTitle("AutoMation Report");
		htmlReport.config().setReportName("Functional Report");
		htmlReport.config().setTheme(Theme.DARK);
		extentReportObj = new ExtentReports();
		extentReportObj.attachReporter(htmlReport);

	}

	public void setExtentLogger(String tcName) {
		extentTestObj = extentReportObj.createTest(tcName);
	}

	public void flushReport() {
		extentReportObj.flush();
	}

}
