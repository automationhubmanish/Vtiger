package com.evs.vtiger.pages.sales.potaintial;
import java.util.Map;
import org.openqa.selenium.support.PageFactory;
import com.evs.vtiger.pages.sales.potaintial.or.OrDeletePotential;
import com.evs.vtiger.utility.WdUtil;

public class VerifyDeletePotential extends OrDeletePotential{

	private WdUtil webUtil;
	private Map<String,String> dataMap;

	public  VerifyDeletePotential (WdUtil webUtil,Map<String,String> dataMap) {
		this.webUtil=webUtil;
		this.dataMap=dataMap;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	public void verifyDeletePotential() { 
		webUtil.jsClick(commonDeletBtn);
		webUtil.popUpdismiss();
		
	}
	

}
