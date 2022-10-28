package com.evs.vtiger.pages.sales.potaintial;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.exceldata.ExcelDataUtil;
import com.evs.vtiger.pages.sales.potaintial.or.OrCreateAccountPage;
import com.evs.vtiger.utility.WdUtil;

public class AccountCreatePage extends OrCreateAccountPage{

	private WdUtil webUtil;
	private Map<String,String>dataMap;
	private ExcelDataUtil excelData;
	public AccountCreatePage(WdUtil webUtil,Map<String,String>dataMap) {
		this.webUtil=webUtil;
		this.dataMap=dataMap;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement accountNam;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement accountDescription;
	
	@FindBy(xpath = "//input[@name='assigntype']")
	private WebElement redioBtn;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@name='email1']")
	private WebElement email;
	
	public void enterMandetoryAccountInfo() throws IOException {
		
		String accountName=dataMap.get("CreateAccount_AccountName_ED");
		webUtil.input(accountNam,accountName);
		String accountPhone=dataMap.get("CreateAccount_PhoneNumber_ED");
		webUtil.input(phoneNumber,accountPhone);
		String accountDescr=dataMap.get("CreateAccount_Description_TB"); 
		webUtil.input(accountDescription,accountDescr);
		String accountemail=dataMap.get("CreateAccount_Email_ED");
		webUtil.input(email,accountemail);
//		String accountRedioBtn=dataMap.get("CreateAccount_Redio_Btn");
		webUtil.click(redioBtn);
		
		
	}
	
	public void saveAccount() {
		webUtil.jsClick(commonSaveBtn);
	}
	
	
	public void cancelAccount() {
		webUtil.click(commonCancelBtn);
	}

	public void deletePotential() {

		webUtil.click(commonDeletBtn);
	}

	public void verifyVisibleElement(String expHederDetail) {

		webUtil.verifyInnerTextContains(commonDetailsHeader,expHederDetail);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
