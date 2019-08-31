package com.company.selenium.handle;

import java.io.IOException;

import com.company.selenium.base.DriverBase;
import com.company.selenium.page.MyShopCarPage;

public class MyShopCarHandle {
	public DriverBase driver;
	public MyShopCarPage msc;
	public MyShopCarHandle(DriverBase driver) {
		this.driver = driver;
		msc = new MyShopCarPage(driver);
	}
	/**
	 * �����ȥ���㡱��ť
	 * @throws IOException 
	 */
	public void clickJieSuanButton() throws IOException {
		msc.click(msc.getJieSuanElement());
	}
}
