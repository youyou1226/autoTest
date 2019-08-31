package com.company.selenium.page;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.company.selenium.base.DriverBase;
//元素层（课程页面）--该层都是获取元素
public class CoursePage extends BasePage{

	public CoursePage(DriverBase driver) {
		super(driver);
	}
	/**
	 * 获取课程详情页面左上角课程名
	 * @throws IOException 
	 */
	public WebElement  getCourseElement() throws IOException {
		return nodeElement(driver.byStr("course1"),driver.byStr("course2"));
	}
	/**
	 * 获取立即购买按钮element
	 * @throws IOException 
	 */
	public WebElement getBuyCourseElement() throws IOException {
		return element(driver.byStr("buynow"));
	}
	/**
	 * 获取添加购物车
	 * @throws IOException 
	 */
	public WebElement getAddShopCarElement() throws IOException {
		return element(driver.byStr("addShopCar"));
		 
		
	}
	/**
	 * 获取右上角购物车element
	 * @throws IOException 
	 */
	public WebElement getShopCarElement() throws IOException {
		return element(driver.byStr("shopCar"));
		
	}
	/**
	 * 获取购物车数量element
	 * @throws IOException 
	 */
	public WebElement getShopCarNumber() throws IOException {
		return element(driver.byStr("carNum"));
	}
	/**
	 * 获取弹窗:继续逛逛Element
	 * @throws IOException 
	 */
	public WebElement getMotaiElement() throws IOException {
		return this.element(driver.byStr("alert2"));
		//return this.nodeElement(driver.byStr("alert1"),driver.byStr("alert2"));		  
	}
}
