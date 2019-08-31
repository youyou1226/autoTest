package com.company.selenium.page;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import com.company.selenium.base.DriverBase;

//元素层（登录页面）
public class LoginPage extends BasePage{
	public LoginPage(DriverBase driver) {
		super(driver);	
		
	}
/**
 * 获取用户名输入框element
 * @throws IOException 
 */
	public WebElement getUserElement() throws IOException {
		return element(driver.byStr("nameLocation"));
	}
/**
 * 获取密码输入框element
 * @throws IOException 
 */
	public WebElement getPasswordElement() throws IOException {
		return element(driver.byStr("passwordLocation"));
	}
/**
 * 获取登录按钮element
 * @throws IOException 
 */
	public WebElement getLoginButtonElement() throws IOException {
		return element(driver.byStr("buttionLocation"));
	}
/**
 * 获取自动登录element
 * @throws IOException 
 */
	public WebElement getAutoLoginElement() throws IOException {
		return element(driver.byStr("autologin"));
	}
}
