package com.evs.vtiger.pages.sales.potaintial;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.pages.sales.potaintial.or.OrPotaintialLandingPage;
import com.evs.vtiger.utility.WdUtil;

public class PotaintialLandingPage extends OrPotaintialLandingPage {
	private WdUtil webUtil;
	private Map<String,String> dataMap;
	public PotaintialLandingPage(WdUtil webUtil,Map<String,String> dataMap) {
		this.webUtil=webUtil;
		this.dataMap=dataMap;
		PageFactory.initElements(webUtil.getDriver(),this);
	}
	
	public void clickCreatePotaintialBtn() {
		webUtil.jsClick(commonCreateBtn);
	}
	
	public void editPotaintialBtn() {
		webUtil.click(commonEditBtn);
	}
	
}
