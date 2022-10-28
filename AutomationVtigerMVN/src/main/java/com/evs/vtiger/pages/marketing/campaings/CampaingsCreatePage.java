package com.evs.vtiger.pages.marketing.campaings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.or.campaings.pages.OrCampaings;
import com.evs.vtiger.utility.WdUtil;

public class CampaingsCreatePage extends OrCampaings {

	private WdUtil webUtil;
	public CampaingsCreatePage(WdUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement weCampaignname;

	public void enterMandetaryInfo() {
		webUtil.click(weCampaignname);
	}

	public void saveCampaings() {
		webUtil.click(commonSaveBtn);
	}

	public void cancleCampaings() {
		webUtil.click(commonCancelBtn);
	}








}
