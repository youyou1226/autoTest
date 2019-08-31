package com.company.selenium.business;

import java.io.IOException;

import com.company.selenium.base.DriverBase;
import com.company.selenium.handle.LoginPageHandle;
//业务层（一些判断，逻辑）
public class LoginPro {
	public DriverBase driver;
	public LoginPageHandle lph;
	
	public LoginPro(DriverBase driver) {
		this.driver = driver;
		lph = new LoginPageHandle(driver);
	}
	public void login(String username,String password) throws IOException {
		if (lph.assertLoginPage()) {//判断是否在登录页面
			lph.sendKeysUser(username);
			lph.sendKeysPassword(password);
			lph.autoLoginClick();
			lph.clickLoginButton();
		}else {
			System.out.println("页面不存在或状态不正确");
		}
	}
}
