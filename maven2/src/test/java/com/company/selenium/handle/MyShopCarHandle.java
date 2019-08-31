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
	 * 点击“去结算”按钮
	 * @throws IOException 
	 */
	public void clickJieSuanButton() throws IOException {
		msc.click(msc.getJieSuanElement());
	}
}
