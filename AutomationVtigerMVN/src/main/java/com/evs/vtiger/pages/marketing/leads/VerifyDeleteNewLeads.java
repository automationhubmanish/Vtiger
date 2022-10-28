package com.evs.vtiger.pages.marketing.leads;

import org.openqa.selenium.support.PageFactory;
import com.evs.vtiger.pages.or.leads.OrDeleteLeads;
import com.evs.vtiger.utility.WdUtil;


public class VerifyDeleteNewLeads extends OrDeleteLeads{

	private WdUtil webUtil;
	
	public	VerifyDeleteNewLeads(WdUtil webUtil){
		this.webUtil= webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}
	
	public void verifyDeleteLeads(String expPopUpText) {
		webUtil.jsClick(commonDeletBtn);
		webUtil.popUpAccept(expPopUpText);

	}
}
