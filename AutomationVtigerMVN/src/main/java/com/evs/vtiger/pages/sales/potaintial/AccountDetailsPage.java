package com.evs.vtiger.pages.sales.potaintial;
import org.openqa.selenium.support.PageFactory;
import com.evs.vtiger.pages.sales.potaintial.or.OrSalesAccountDetailsPage;
import com.evs.vtiger.utility.WdUtil;

public class AccountDetailsPage extends OrSalesAccountDetailsPage{

	private WdUtil webUtil;


	public AccountDetailsPage(WdUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);		

	}

	public void verifyAccountName(String expAccountName) {
		
		webUtil.verifyInnerText(accountName,expAccountName);
	}
	
	public void verifyAccountEmail(String expAccountEmail) {
		webUtil.verifyInnerText(accountEmail,expAccountEmail);
	}
	
	public void verifyAccountAssigned(String expAccountAssigned) {
		webUtil.verifyInnerText(accountAssigned,expAccountAssigned);
	}
	
	public void verifyAccountNo(String expAccountNo) {
		webUtil.verifyInnerText(accountNo,expAccountNo);
	}
	
	public void verifyAccountDescr(String expAccountDescr) {
		webUtil.verifyInnerText(accountDescr,expAccountDescr);
	}
	





}
