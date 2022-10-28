package com.evs.vtiger.pages.sales.potaintial.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.or.common.OrCommon;

public class OrSalesAccountDetailsPage extends OrCommon{
	
	@FindBy(xpath = "//td[@id='mouseArea_Account Name']//span")
	protected WebElement accountName;
	
	@FindBy(xpath = "//td[contains(text(),'Account No')]")
	protected WebElement accountNo;
	
	@FindBy(xpath = "//td[@id='mouseArea_Assigned To']")
	protected WebElement accountAssigned;
	
	@FindBy(xpath = "//td[@id='mouseArea_Email']")
	protected WebElement accountEmail;
	
	@FindBy(xpath = "//td[@id='mouseArea_Description']")
	protected WebElement accountDescr;
	
	
	
	
	

}
