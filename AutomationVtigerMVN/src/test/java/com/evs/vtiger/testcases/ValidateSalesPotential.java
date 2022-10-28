package com.evs.vtiger.testcases;
import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.sales.potaintial.CreatePotaintialPage;
import com.evs.vtiger.pages.sales.potaintial.PotaintialLandingPage;
import com.evs.vtiger.pages.sales.potaintial.PotentialDetailspage;
import com.evs.vtiger.pages.sales.potaintial.VerifyDeletePotential;

public class ValidateSalesPotential extends BaseTest{

	@Test(priority=1)
	public void vt004ValidateCreatePotential() throws IOException {
		dataMapList = excelData.getTestCaseData("src\\main\\resources\\TestCaseData\\TestData.xlsx","vt004ValidateCreatePotential");
		for(int i=0;i<=dataMapList.size()-1;i++) {
			Map<String,String> dataMap=dataMapList.get(i);
			HomePage homePg = new HomePage(webUtil);
			homePg.gotoSalesPotential();
			PotaintialLandingPage potentialLandingPg = new PotaintialLandingPage(webUtil,dataMap);
			potentialLandingPg.clickCreatePotaintialBtn();;
			CreatePotaintialPage potentialCreatePage = new CreatePotaintialPage(webUtil, dataMap); 
			potentialCreatePage.enterMandentoryPotentialInfo();
			potentialCreatePage.savePotential();
			PotentialDetailspage potentialVerifyDetail = new PotentialDetailspage(webUtil);
			String expPotentialName=	dataMap.get("expPotentialName");
			potentialVerifyDetail.verifyPotentialName(expPotentialName);
			String expAccountN=	dataMap.get("expPotentialAccount");
			potentialVerifyDetail.verifyPotentialAccount(expAccountN);
			String expStage=	dataMap.get("expPotentialStage");
			potentialVerifyDetail.verifyPotentialStage(expStage);
			String expCloseDate=	dataMap.get("expCloseDate");
			potentialVerifyDetail.verifyPotentialCloseDate(expCloseDate);
			String expDescr=	dataMap.get("expPotentialDescr");
			potentialVerifyDetail.verifyPotentialDesr(expDescr);
			VerifyDeletePotential verifyDeletePotential = new VerifyDeletePotential(webUtil, dataMap);
			verifyDeletePotential.verifyDeletePotential();
		}
	}

}
