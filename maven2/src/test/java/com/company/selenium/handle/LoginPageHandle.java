package com.company.selenium.handle;


import java.io.IOException;

import javax.sound.midi.VoiceStatus;

import org.openqa.selenium.WebElement;

import com.company.selenium.base.DriverBase;
import com.company.selenium.page.LoginPage;
//操作层
public class LoginPageHandle {
	public DriverBase driver;
	public LoginPage lp;
	
	public LoginPageHandle(DriverBase driver) {
		this.driver = driver;
		lp = new LoginPage(driver);
	}
	/**
	 * 输入用户名
	 * @throws IOException 
	 */
	public void sendKeysUser(String username) throws IOException {
		lp.sendKeys(lp.getUserElement() , username);//调用的是BasePage里面的sendKeys方法
	}
	/**
	 * 输入密码
	 * @throws IOException 
	 */
	public void sendKeysPassword(String password) throws IOException {
		lp.sendKeys(lp.getPasswordElement(), password);
	}
	/**
	 * 点击自动登录
	 * @throws IOException 
	 */
	public void autoLoginClick() throws IOException {		
			lp.click(lp.getAutoLoginElement());			
	}
	/**
	 * 点击登录
	 * @throws IOException 
	 */
	public void clickLoginButton() throws IOException {
		lp.click(lp.getLoginButtonElement());//调用的是BasePage里面的click方法
	}
	/**
	 * 判断是否是登录页面
	 * @throws IOException 
	 */
	public boolean assertLoginPage() throws IOException {
		return lp.assertElementIs(lp.getUserElement());
	}
}
