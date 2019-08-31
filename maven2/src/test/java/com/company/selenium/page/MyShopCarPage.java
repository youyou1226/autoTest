package com.company.selenium.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.company.selenium.base.DriverBase;

//我的购物车页面
public class MyShopCarPage extends BasePage{

	public MyShopCarPage(DriverBase driver) {
		super(driver);
	}
	/**
	 * 去结算按钮
	 * @throws IOException 
	 */
	public WebElement getJieSuanElement() throws IOException {
		return element(driver.byStr("jieSuan"));	
	}
}
