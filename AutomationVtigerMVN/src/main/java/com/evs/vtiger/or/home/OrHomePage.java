package com.evs.vtiger.or.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.or.common.OrCommon;

public class OrHomePage extends OrCommon{

	@FindBy(xpath = "//a[text()='Marketing']")
	protected WebElement mouseOverOnMarketing;
	
	@FindBy(xpath = "//td[@class='moduleName']")
	protected WebElement homePage;	
	
	@FindBy(xpath = "//a[text()='Sales']")
	protected WebElement mouseOverOnSales;

	@FindBy(xpath = "//a[text()='Support']")
	protected WebElement mouseOverOnSupport;

	@FindBy(xpath = "//a[text()='Analytics']")	
	protected WebElement mouseOverOnAnalytics;

	@FindBy(xpath = "//a[text()='Inventory']")	
	protected WebElement mouseOverOnInventory;

	@FindBy(xpath = "//a[text()='Tools']")	
	protected WebElement mouseOverOnTool;

	@FindBy(xpath = "//a[text()='Settings']")	
	protected WebElement mouseOverOnSetting;



}
