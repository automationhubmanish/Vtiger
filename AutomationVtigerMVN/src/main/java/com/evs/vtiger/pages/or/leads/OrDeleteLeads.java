package com.evs.vtiger.pages.or.leads;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.evs.vtiger.or.common.OrCommon;

public class OrDeleteLeads extends OrCommon {

	@FindBy(xpath ="//input[@name='selectall']")
	protected WebElement clickOnLead;
}
