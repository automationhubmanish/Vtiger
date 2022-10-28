package com.evs.vtiger.pages.marketing.leads;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.pages.or.leads.OrCreateLeads;
import com.evs.vtiger.utility.WdUtil;

public class LeadsLandingPage extends OrCreateLeads {

	private WdUtil webUtil;

	public LeadsLandingPage(WdUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}


	public void clickCreateLeadBtn() {
		webUtil.jsClick(commonCreateBtn);
	}
	public void clickEditBtn() {
		webUtil.click(commonEditBtn);
	}


}
