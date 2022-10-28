package com.evs.vtiger.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.evs.vtiger.or.home.OrHomePage;
import com.evs.vtiger.utility.WdUtil;


public class HomePage extends OrHomePage{

	private WdUtil webUtil;
	public HomePage(WdUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "(//a[text()='Leads'])[3]")
	private WebElement weClickOnLeads;

	@FindBy(xpath = "(//a[text()='Accounts'])[3]")
	private WebElement weAccounts;

	@FindBy(xpath = "(//a[text()='Campaigns'])[3]")
	private WebElement weCampaigns;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Contacts']")
	private WebElement weContacts;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Webmail']")
	private WebElement weWebMail;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Calendar']")
	private WebElement weCalender;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Documents']")
	private WebElement weDocuments;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement weLogOut;

	@FindBy(xpath = "//td[@class='level2SelTab']//a[text()='Leads']")
	private WebElement weSalesLeads;
	
	@FindBy(xpath = "(//a[text()='Accounts'])[2]")
	private WebElement weSalesAccounts;
	
	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Contacts']")
	private WebElement wesalesContacts;
	
	@FindBy(xpath = "//div[@id='Sales_sub']//a[text()='Potentials']")
	private WebElement weSalesPotentials;
	
	@FindBy(xpath = "//td[@class='level2SelTab']//a[text()='Quotes']")
	private WebElement weSalesQuotes;
	
	@FindBy(xpath = "//td[@class='level2SelTab']//a[contains(text(),'Sales Order')]")
	private WebElement weSalesSalesOrder;
	
	@FindBy(xpath = "//td[@class='level2SelTab']//a[contains(text(),'Invoice')]")
	private WebElement weSalesInvoice;
	
	@FindBy(xpath = "//td[@class='level2SelTab']//a[contains(text(),'Price Books')]")
	private WebElement weSalesPrcBooks;
	
	@FindBy(xpath = "//td[@class='level2SelTab']//a[contains(text(),'Documents')]")
	private WebElement weSalesDoc;
	
	@FindBy(xpath = "//td[@class='level2SelTab']//a[contains(text(),'Calendar')]")
	private WebElement weSalesCalendar;
	
	@FindBy(xpath = "//td[@class='level2SelTab']//a[contains(text(),'Sales Order')]")
	private WebElement weSalesOrder;
	
	public void mouseOverMarketing() {
		webUtil.jsMouseOver(mouseOverOnMarketing);

	}
	
	
	public void gotoMarketingLeads() {
		mouseOverMarketing();
		webUtil.jsClick(weClickOnLeads);

	}

	public void gotoMarketingAccounts() {
		mouseOverMarketing();
		webUtil.click(weAccounts);
	}

	public void gotoCampaings() {
		mouseOverMarketing();
		webUtil.click(weCampaigns);
	}
	public void gotoContacts() {
		mouseOverMarketing();
		webUtil.click(weContacts);
	}

	public void gotoWebmail	() {
		mouseOverMarketing();
		webUtil.click(weWebMail);
	}

	public void gotoCalendar() {
		mouseOverMarketing();
		webUtil.click(weCalender);
	}

	public void gotoDocuments() {
		mouseOverMarketing();
		webUtil.click(weDocuments);


	}
	public void validateHomePage(String expText) {
		webUtil.validateElementVisible(homePage);
		webUtil.verifyInnerText(homePage,expText);
		
	}
	public void logOut() {

		webUtil.jsClick(weLogOut);
		Reporter.log("LogOut succesefully done :");
	}

	public void mouseOverSales() {
		webUtil.jsMouseOver(mouseOverOnSales);

	}
	
	public void mouseOverAnalytics() {
		webUtil.jsMouseOver(mouseOverOnAnalytics);

	}

	public void mouseOverInventory() {
		webUtil.jsMouseOver(mouseOverOnInventory);

	}
	public void mouseOverTools() {
		webUtil.jsMouseOver(mouseOverOnTool);

	}
	public void mouseOverSupport() {
		webUtil.jsMouseOver(mouseOverOnSupport);

	}
	
public void gotoSalesLeads() {
	mouseOverSales();
	webUtil.jsClick(weSalesLeads);
}
	
public void gotoSalesAccounts() {
	mouseOverSales();
	webUtil.jsClick(weSalesAccounts);
}
	
public void gotoSalesContact() {
	mouseOverSales();
	webUtil.jsClick(wesalesContacts);
}	
	
public void gotoSalesPotential() {
	mouseOverSales();
	webUtil.jsClick(weSalesPotentials);
}

public void gotoSalesQuotes() {
	mouseOverSales();
	webUtil.jsClick(weSalesQuotes);
}

public void gotoSalesOrder() {
	mouseOverSales();
	webUtil.jsClick(weSalesOrder);
}

public void gotoSalesInVoice() {
	mouseOverSales();
	webUtil.jsClick(weSalesInvoice);
}

public void gotoSalesPrcBooks() {
	mouseOverSales();
	webUtil.jsClick(weSalesPrcBooks);
}

public void gotoSalesDocuments() {
	mouseOverSales();
	webUtil.jsClick(weSalesDoc);
}

public void gotoSalesCalender() {
	mouseOverSales();
	webUtil.jsClick(weSalesCalendar);
}


}
