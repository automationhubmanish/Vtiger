package com.evs.vtiger.or.common;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class OrCommon {

	@FindBy(xpath = "//input[contains(@title,'Save')]")
	protected  WebElement 	commonSaveBtn;

	@FindBy(xpath = "//input[contains(@title,'Cancel')]")
	protected  WebElement  commonCancelBtn;

	@FindBy(xpath = "//td//span[@class='dvHeaderText']")
	protected WebElement   commonDetailsHeader;

	@FindBy(xpath = "//td[@class='dvtTabCache']//input[@name='Delete']")
	protected WebElement commonDeletBtn;
	@FindBy(xpath = "//img[contains(@title,'Create')]")
	protected WebElement commonCreateBtn;

	@FindBy(xpath = "//input[@name='Edit']")
	protected WebElement commonEditBtn;
}
