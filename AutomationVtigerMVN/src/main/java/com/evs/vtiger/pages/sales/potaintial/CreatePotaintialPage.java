package com.evs.vtiger.pages.sales.potaintial;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.evs.vtiger.pages.sales.potaintial.or.OrCreatePotaintialPage;
import com.evs.vtiger.utility.WdUtil;

public class CreatePotaintialPage extends OrCreatePotaintialPage{

	private WdUtil webUtil;
	private Map<String,String> dataMap;

	public CreatePotaintialPage(WdUtil webUtil,Map<String,String> dataMap) {
		this.webUtil=webUtil;
		this.dataMap=dataMap;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement potentialName;

	@FindBy(xpath = "(//img[@language='javascript'])[1]")
	private WebElement selectAccount;

	@FindBy(xpath="//a[text()='Manish']")
	private WebElement clickOnAccount;

	@FindBy(xpath = "//input[@name='closingdate']")
	private WebElement dateOfPotential;

	@FindBy(xpath = "//input[@name='assigntype']")
	private WebElement redioBtn;

	@FindBy(xpath = "//input[@name='probability']")
	private WebElement salesStage;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descr;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement clickOnSearchBtn;

	public void enterMandentoryPotentialInfo() throws IOException {

		String potName=dataMap.get("Potential_PotentialName_ED");
		webUtil.input(potentialName, potName);
		webUtil.jsClick(selectAccount);
		String expWindowTitle=dataMap.get("expWindowTitle");
		webUtil.switchToWindowsByTitle(expWindowTitle);
		String accountName=dataMap.get("Potential_AccountData_SB");
		webUtil.input(searchBox, accountName);
		webUtil.jsClick(clickOnSearchBtn);
		webUtil.jsClick(clickOnAccount);
		String expTitle=dataMap.get("expTitleOfPage"); 
		webUtil.switchToWindowsByTitle(expTitle);
//		String potentialRedioBtn=	dataMap.get("Potential_Redio_Btn");
//		webUtil.input(redioBtn, potentialRedioBtn);
//		String potentialcloseDate	=dataMap.get("Potential_CloseDate_ED");
//		webUtil.input(dateOfPotential, potentialcloseDate);
		String potentialDescr=dataMap.get("Potential_Description_TB");
		webUtil.input(descr, potentialDescr);
		String potentialStage=dataMap.get("Potential_salesStage_ED");
		webUtil.input(salesStage, potentialStage);
 
	}

	public void savePotential() {
		webUtil.jsClick(commonSaveBtn);
	}


	public void cancelPotential() {
		webUtil.click(commonCancelBtn);
	}

	public void deletePotential() {
		webUtil.click(commonDeletBtn);
	}

	public void verifyVisibleElement(String expInnerText) {

		webUtil.verifyInnerTextContains(commonDetailsHeader,expInnerText);

	}






}
