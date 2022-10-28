package com.evs.vtiger.pages.sales.potaintial;

import com.evs.vtiger.pages.sales.potaintial.or.OrDeleteAccountPage;
import com.evs.vtiger.utility.WdUtil;

public class VerifyDeleteAccountPage extends OrDeleteAccountPage{

	private WdUtil webUtil;
	public VerifyDeleteAccountPage(WdUtil webUtil) {
		this.webUtil=webUtil;
	}
	
	
	
	public void deleteAccount(String expPOPUpText) {
		webUtil.jsClick(commonDeletBtn);
		webUtil.popUpAccept(expPOPUpText);
		
		
	}
	
	
	
	
	
}
