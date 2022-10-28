package com.evs.vtiger.pages.sales.potaintial;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.pages.sales.potaintial.or.OrAccountLandingPage;
import com.evs.vtiger.utility.WdUtil;

public class AccountLandingPage extends OrAccountLandingPage{

	private WdUtil webUtil;
	public AccountLandingPage(WdUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	public void CreateAccountBtn() {
		webUtil.jsClick(commonCreateBtn);
	}

	public void EditAccountBtn() {
		webUtil.jsClick(commonEditBtn);
	}



}
