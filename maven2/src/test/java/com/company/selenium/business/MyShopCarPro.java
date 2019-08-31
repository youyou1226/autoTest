package com.company.selenium.business;

import java.io.IOException;

import com.company.selenium.base.DriverBase;
import com.company.selenium.handle.MyShopCarHandle;

public class MyShopCarPro {
	public MyShopCarHandle msch;
	public DriverBase driver;
	public MyShopCarPro(DriverBase driver) {
		this.driver = driver;
		msch = new MyShopCarHandle(driver);
	}
	/**
	 * ��ȥ���㡱��ť
	 * @throws IOException 
	 */
	public void jieSuanButton() throws IOException {
		msch.clickJieSuanButton();
	}
	
}
