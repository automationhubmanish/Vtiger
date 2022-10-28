package com.evs.vtiger.testcases;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.sales.potaintial.AccountCreatePage;
import com.evs.vtiger.pages.sales.potaintial.AccountDetailsPage;
import com.evs.vtiger.pages.sales.potaintial.AccountLandingPage;
import com.evs.vtiger.pages.sales.potaintial.VerifyDeleteAccountPage;

public class ValidateSalesAccount extends BaseTest{

	@Test(priority=1)
	public void vt003ValidateCreateAccount() throws IOException {
		dataMapList = excelData.getTestCaseData("src\\main\\resources\\TestCaseData\\TestData.xlsx","vt003ValidateCreateAccount");
		for(int i=0;i<=dataMapList.size()-1;i++) {
			Map<String,String> dataMap=dataMapList.get(i);
			HomePage homePg = new HomePage(webUtil);
			homePg.gotoSalesAccounts();
			AccountLandingPage accountLandingPg= new AccountLandingPage(webUtil);
			accountLandingPg.CreateAccountBtn();
			AccountCreatePage accountCreatePage=new AccountCreatePage(webUtil,dataMap);
			accountCreatePage.enterMandetoryAccountInfo();
			accountCreatePage.saveAccount();
			AccountDetailsPage accountDetailsPg=new AccountDetailsPage(webUtil);
			String expAccountName=dataMap.get("expAccountName");
			accountDetailsPg.verifyAccountName(expAccountName);
			String expAccountNo=dataMap.get("expAccountNo");
			accountDetailsPg.verifyAccountNo(expAccountNo);
			String expAccountAssigned=dataMap.get("expAccountAssiged");
			accountDetailsPg.verifyAccountAssigned(expAccountAssigned);
			String expAccountDescr=dataMap.get("expAccountDescr");
			accountDetailsPg.verifyAccountDescr(expAccountDescr);
			String expAccountEmail=dataMap.get("expAccountEmail");
			accountDetailsPg.verifyAccountEmail(expAccountEmail);
//			VerifyDeleteAccountPage accountDeletePg = new VerifyDeleteAccountPage(webUtil);
//			String expPopUpText =dataMap.get("expPopUPText");
//			accountDeletePg.deleteAccount(expPopUpText);
		}
	}


}
