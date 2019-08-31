package com.company.selenium.page;
//元素层
/**
 * 个人信息页面
 * @author 61795
 *
 */

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.company.selenium.base.DriverBase;

public class PersonalInforPage extends BasePage{

	public PersonalInforPage(DriverBase driver) {
		super(driver);
	}
	/**
	 * 获取“慕运维2204313”element
	 * @throws IOException 
	 */
	public WebElement getNameElement() throws IOException {
		WebElement element = element(driver.byStr("persionalInfor"));
		return element;
		
	}
}
