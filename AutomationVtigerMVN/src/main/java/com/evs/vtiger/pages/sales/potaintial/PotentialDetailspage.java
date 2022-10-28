package com.evs.vtiger.pages.sales.potaintial;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.pages.sales.potaintial.or.OrDetailsPotentialPage;
import com.evs.vtiger.utility.WdUtil;

public class PotentialDetailspage extends OrDetailsPotentialPage{

	private WdUtil webUtil;

	public PotentialDetailspage(WdUtil webUtil){
		this.webUtil=webUtil;
	
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	public void verifyPotentialStage(String expPotentialStage) {
		webUtil.verifyInnerText(PotentiaStage,expPotentialStage);	
	}

	public void verifyPotentialAccount(String expPotentialAccountName) {
		webUtil.verifyInnerText(AccountName,expPotentialAccountName);	
	}

	public void verifyPotentialRedioBtn() {
		webUtil.selected(redioBtn);	
	}

	public void verifyPotentialName(String expPotentialName) {
		webUtil.verifyInnerText(PotentialName,expPotentialName);	
	}

	public void verifyPotentialDesr(String expPotentialDescr) {
		webUtil.verifyInnerText(PotentialDescr,expPotentialDescr);	
	}

	public void verifyPotentialCloseDate(String expPotentialDate) {
		webUtil.verifyInnerText(PotentialCloseDate,expPotentialDate);	
	}




}
