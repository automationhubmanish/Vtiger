package com.evs.vtiger.pages.sales.potaintial.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.or.common.OrCommon;

public class OrDeleteAccountPage extends OrCommon{
	
	@FindBy(xpath = "//input[@name='selectall']")
	protected WebElement clickOnAccount;
	
	
}
