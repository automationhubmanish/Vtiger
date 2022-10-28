package com.evs.vtiger.pages.marketing.campaings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utility.WdUtil;




public class verifyCompaingn {
	
	private WdUtil webUtil;
	
	@FindBy(xpath = "//td[@class='searchAlph']")
	private WebElement weSearchAlph;
	
	public verifyCompaingn() {
		this.webUtil=webUtil;
		
	}
	public void verifyCompaingAlphaBet() {
	webUtil.click(weSearchAlph);
	
	}

	
	
}
