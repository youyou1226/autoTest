package com.company.selenium.handle;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.company.selenium.base.DriverBase;
import com.company.selenium.page.PersonalInforPage;

public class PersonalInforHandle {
	public DriverBase driver;
	public PersonalInforPage pip;
	public PersonalInforHandle(DriverBase driver) {
		this.driver = driver;
		 pip = new PersonalInforPage(driver);
	}
	/**
	 * 获取“慕运维2204313”文本
	 * @throws IOException 
	 */
	public String getPersionalInforText() throws IOException {
		WebElement element = pip.getNameElement();
		return pip.getText(element);
	}
}
