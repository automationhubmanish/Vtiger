package com.evs.vtiger.pages.login;

import org.openqa.selenium.support.PageFactory;
import com.evs.vtiger.or.login.OrLogin;
import com.evs.vtiger.utility.WdUtil;

public class LoginPage extends OrLogin {

	private WdUtil webUtil;
	
	public LoginPage(WdUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public void validLogin() {
		
		String url = webUtil.getPropObj().getProperty("Url");
		webUtil.getDriver().get(url);
		String expUrl = webUtil.getPropObj().getProperty("ExpUrl");
		webUtil.verifyCurrentUrl(expUrl);
		String expTitle = webUtil.getPropObj().getProperty("ExpTitle");
		webUtil.verifyTitle(expTitle);
		String userName = webUtil.getPropObj().getProperty("UserName");
		webUtil.jsSandkeys(loginUserNameEd,userName);
		String pwd = webUtil.getPropObj().getProperty("Password");
		webUtil.input(loginPasswordEd,pwd);
		webUtil.selectByVisibleText(weLoginThame,"bluelagoon");
		webUtil.jsClick(loginSigninBtn);

	}
	
	public void verifyLogOut() {
		webUtil.verifyElementVisible(loginSigninBtn);
	}

	public void invalidLogin() {

		String url = webUtil.getPropObj().getProperty("Url");
		webUtil.getDriver().get(url);
		String userName = webUtil.getPropObj().getProperty("UserName");
		String pwd = webUtil.getPropObj().getProperty("Password");
		webUtil.jsSandkeys(loginUserNameEd,userName);
		webUtil.jsSandkeys(loginPasswordEd,pwd);
		webUtil.selectByVisibleText(weLoginThame,"bluelagoon");
		webUtil.jsClick(loginSigninBtn);

	}

}
