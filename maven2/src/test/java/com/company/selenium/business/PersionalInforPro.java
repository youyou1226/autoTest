package com.company.selenium.business;

import java.io.IOException;

import com.company.selenium.base.DriverBase;
import com.company.selenium.handle.PersonalInforHandle;
import com.company.selenium.util.PropertiesUtil;

public class PersionalInforPro {
	public DriverBase driver;
	public PersonalInforHandle pih;
	public PropertiesUtil pul;
	public PersionalInforPro(DriverBase driver) {
		this.driver = driver;
		 pih = new PersonalInforHandle(driver);
		
	}
	/**
	 * 获取“慕运维2204313”文本
	 * @throws IOException 
	 */
	public String getText() throws IOException {
		return pih.getPersionalInforText();
	}
	/**
	 * 
	 * 根据用户名判断登录信息是否正确
	 * @throws IOException 
	 */
	public Boolean AssertLogin(String expect) throws IOException {
		if(pih.getPersionalInforText().equals(expect)) {
			return true;
		}
		return false;
		
	}
}
