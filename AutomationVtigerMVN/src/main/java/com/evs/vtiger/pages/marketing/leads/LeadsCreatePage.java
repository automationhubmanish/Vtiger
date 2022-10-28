package com.evs.vtiger.pages.marketing.leads;

import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.evs.vtiger.pages.or.leads.OrCreateLeads;
import com.evs.vtiger.utility.WdUtil;


public class LeadsCreatePage extends OrCreateLeads{

	private WdUtil webUtil;
	private  Map<String,String> dataMap;

	public LeadsCreatePage( WdUtil webUtil,Map<String,String> dataMap) {
		this.webUtil=webUtil;
		this.dataMap=dataMap;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath = "//select[contains(@name,'salutationtype')]")
	private WebElement weDropDown;

	@FindBy(name ="firstname")
	private WebElement weFirstName;

	@FindBy(name = "lastname")
	private WebElement weLastName;

	@FindBy(name = "company")
	private WebElement weCompanyName;

	@FindBy(id = "phone")
	private WebElement wePhoneNo;

	@FindBy(id ="mobile" )
	private WebElement weMobileNo;

	@FindBy(id  = "fax")
	private WebElement weFax;

	@FindBy(id = "email")
	private WebElement weEmail;

	@FindBy(xpath ="//select[@name='leadsource']")
	private WebElement weleadsource;

	@FindBy(xpath = "//select[@name='leadstatus']")
	private WebElement weleadStatus;

	@FindBy(id ="code")
	private WebElement weCode;

	@FindBy(xpath ="//input[@id='country']")
	private WebElement weCountry;

	@FindBy(id  = "pobox")
	private WebElement wePoBox;

	@FindBy(name ="city")
	private WebElement weCity;

	@FindBy(name ="state")
	private WebElement weState;

	@FindBy(xpath = "//textarea[@name='lane']")
	private WebElement weStreet;

	@FindBy(name ="description")
	private WebElement weDescription;
	@FindBy(xpath="(//input[@name='assigntype'])[1]")
	private WebElement redioBtn;
	@FindBy(xpath = "//input[@name='selected_id']")
	private WebElement clickOnLead;

	public void enterLeadsTotaleInfo() {
		String surName=	dataMap.get("CreateLead_SurName_DD");
		webUtil.selectByvalue(weDropDown,surName);
		String LastName=	dataMap.get("CreateLead_LastName_ED");
		webUtil.input(weLastName,LastName);
		String firstname=dataMap.get("CreateLead_FirstName_ED");
		webUtil.input(weFirstName,firstname);
		String CompanyName=	dataMap.get("CreateLead_CompanyName_ED");
		webUtil.input(weCompanyName,CompanyName);
		String PhoneNo=	dataMap.get("CreateLead_Phone_ED");
		webUtil.input(wePhoneNo,PhoneNo);
		String MobileNo=	dataMap.get("CreateLead_Mobile_ED");
		webUtil.input(weMobileNo,MobileNo);
		String Fax=	dataMap.get("CreateLead_Fax_ED");
		webUtil.input(weFax,Fax);
		String Email=	dataMap.get("CreateLead_Email_ED");
		webUtil.input(weEmail,Email);
		String leadsource=	dataMap.get("CreateLead_LeadSource_DD");
		webUtil.selectByvalue(weleadsource,leadsource);
		String leadStatus=	dataMap.get("CreateLead_leadStatus_DD");
		webUtil.selectByvalue(weleadStatus,leadStatus);
		String Code=	dataMap.get("CreateLead_PostalCode_ED");
		webUtil.input(weCode,Code);
		String Country=	dataMap.get("CreateLead_Country_ED");
		webUtil.input(weCountry,Country);
		String PoBox=	dataMap.get("CreateLead_POBox_ED");
		webUtil.input(wePoBox,PoBox);
		String street=	dataMap.get("CreateLead_Street_ED");
		webUtil.input(weStreet,street);
		String City=dataMap.get("CreateLead_City_ED");
		webUtil.input(weCity,City);
		String State=	dataMap.get("CreateLead_State_ED");
		webUtil.input(weState,State);
		String Description=	dataMap.get("CreateLead_Description_TB");
		webUtil.input(weDescription,Description);

	}

	public void saveLeads() {

		webUtil.jsClick(commonSaveBtn);

	}
	
	
	public void cancelLeads() {

		webUtil.click(commonCancelBtn);
	}
	
	public void verifyVisibleElement(String expInnerText) {

		webUtil.verifyInnerTextContains(commonDetailsHeader,expInnerText);

	}
	
	public void selectLead() {
		webUtil.click(clickOnLead);
	}
	
	

}
