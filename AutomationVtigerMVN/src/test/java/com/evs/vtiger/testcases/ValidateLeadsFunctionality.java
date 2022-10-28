package com.evs.vtiger.testcases;
import java.io.IOException;

import java.util.Map;

import org.testng.annotations.Test;
import com.evs.vtiger.pages.home.HomePage; 
import com.evs.vtiger.pages.marketing.leads.LeadsLandingPage;
import com.evs.vtiger.pages.marketing.leads.VerifyDeleteNewLeads;
import com.evs.vtiger.pages.marketing.leads.LeadsCreatePage;
import com.evs.vtiger.pages.marketing.leads.LeadsDetailsPage;

public class ValidateLeadsFunctionality extends BaseTest{

	@Test(priority=1)
	public void vt001ValidateValidLoginpage() throws IOException {
		dataMapList = excelData.getTestCaseData("src\\main\\resources\\TestCaseData\\TestData.xlsx","vt001ValidateValidLoginpage");
		for(int i=0;i<=dataMapList.size()-1;i++) {
			Map<String,String> dataMap=dataMapList.get(i);
			String exHomePg=dataMap.get("Expected_HomePg");
			new HomePage(webUtil).validateHomePage(exHomePg);
		}
	}
	@Test(priority=2)
	public void vt002ValidateCreateLeads() throws IOException {
		dataMapList = excelData.getTestCaseData("src\\main\\resources\\TestCaseData\\TestData.xlsx","vt002ValidateCreateLeads");
		for(int i=0;i<=dataMapList.size()-1;i++) {
			Map<String,String> dataMap=dataMapList.get(i);
			HomePage homePg = new HomePage(webUtil);
			homePg.gotoMarketingLeads();
			LeadsLandingPage leadsLandingPg = new LeadsLandingPage(webUtil);
			leadsLandingPg.clickCreateLeadBtn();
			LeadsCreatePage leadsCreatePage = new LeadsCreatePage(webUtil, dataMap);
			leadsCreatePage.enterLeadsTotaleInfo();
			leadsCreatePage.saveLeads();
			LeadsDetailsPage leadVerifyDetail = new LeadsDetailsPage(webUtil);
			String expHederDetail=	dataMap.get("Expected_HeaderDetails");
			leadVerifyDetail.verifyLeadsDetailHeader(expHederDetail);
			String expLastName=	dataMap.get("Expected_LastName");
			leadVerifyDetail.verifyLastName(expLastName);
			String expCompny=dataMap.get("Expected_CompanyName");
			leadVerifyDetail.verifyCompanyName(expCompny);
			String expAssign=	dataMap.get("expectedAssign");
			leadVerifyDetail.verifyAssigned(expAssign);
			String expEmail=	dataMap.get("expectedEmail");
			leadVerifyDetail.verifyEmail(expEmail);
			String expMobile=	dataMap.get("expectedMobile");
			leadVerifyDetail.verifyMobileNumber(expMobile);
			String expPhone=	dataMap.get("expPhone");
			leadVerifyDetail.verifyPhone(expPhone);
			String expTitle=dataMap.get("expectedAssign");
			leadVerifyDetail.verifyTitle(expTitle);
			String expDescription=	dataMap.get("expectedDescription");
			leadVerifyDetail.verifyDescription( expDescription);
//			VerifyDeleteNewLeads vrfydelLead=new VerifyDeleteNewLeads(webUtil);
//			String expPopUpText=dataMap.get("expPopUPText");
//			vrfydelLead.verifyDeleteLeads(expPopUpText);
        
		}
	} 
}
