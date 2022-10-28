package com.evs.vtiger.pages.marketing.campaings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utility.WdUtil;


public class CampaingsLandingPage {
	private WdUtil webUtil;
public CampaingsLandingPage(WdUtil webUtil) {
	this.webUtil=webUtil;
	PageFactory.initElements(webUtil.getDriver(),this);
	
}
@FindBy(xpath = "//img[@title='Create Campaign...']")	
private WebElement weClickBtnCampaings;



public void clickCmpCreateBtn() {
	webUtil.click(weClickBtnCampaings);
	
}
	
}
