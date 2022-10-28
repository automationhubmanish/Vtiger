package com.evs.vtiger.pages.or.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.or.common.OrCommon;

public class OrDetailsPage extends OrCommon {
	
	@FindBy(xpath ="//span[@id='dtlview_Company']")
	protected WebElement companyName;
	
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	protected WebElement lastName ;
	
	@FindBy(xpath ="//td[@class='moduleName']")
	protected WebElement detailHeaderLeads;
	
	@FindBy(xpath = "//td[@id='mouseArea_Title']")
	protected WebElement weTitle;
	
	@FindBy(xpath = "//td[@id='mouseArea_Phone']")
	protected WebElement wePhone;
	
	@FindBy(xpath = "//td[@id='mouseArea_Mobile']")
	protected WebElement weMobile;
	
	@FindBy(xpath = "//td[@id='mouseArea_Email']")
	protected WebElement weEmail;
	
	@FindBy(xpath = "//td[@id='mouseArea_Description']")
	protected WebElement weDescription;
	
	@FindBy(xpath = "//td[@id='mouseArea_Assigned To']")
	protected WebElement weAssigned;
	
	
}
