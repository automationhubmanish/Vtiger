package com.evs.vtiger.pages.sales.potaintial.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.evs.vtiger.or.common.OrCommon;

public class OrDetailsPotentialPage extends OrCommon{
	
	@FindBy(xpath = "//td[contains(text(),'Potential Name')]")
	protected WebElement PotentialName;
	
	@FindBy(xpath = "//td[contains(text(),'Related To')]")
	protected WebElement AccountName;
	
	@FindBy(xpath = "//td[contains(text(),'Assigned To')]")
	protected WebElement redioBtn;
	
	@FindBy(xpath = "//td[contains(text(),'Sales Stage')]")
	protected WebElement PotentiaStage;
	
	@FindBy(xpath = "//td[contains(text(),'Expected Close Date')]")
	protected WebElement PotentialCloseDate;
	
	@FindBy(xpath = "//td[contains(text(),'Description')]")
	protected WebElement PotentialDescr;
	
}
