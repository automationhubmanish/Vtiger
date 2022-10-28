package com.evs.vtiger.or.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.or.common.OrCommon;

public class OrLogin extends OrCommon{
	@FindBy(xpath = "//input[@name='user_name']")
	protected WebElement  loginUserNameEd ;
	
	@FindBy(xpath = "//input[@name='user_password']")
	protected WebElement loginPasswordEd;
	
	@FindBy(xpath = "//input[@name='Login']")
	protected WebElement loginSigninBtn;
	
	@FindBy(xpath = "//select[@name='login_theme']")
	protected WebElement weLoginThame;
}
