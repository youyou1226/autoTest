package com.company.selenium.handle;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebElement;

import com.company.selenium.base.DriverBase;
import com.company.selenium.page.CoursePage;


public class CoursePageHandle {	
	public DriverBase driver;
	public CoursePage cp ;
	public CoursePageHandle(DriverBase driver) {
		this.driver = driver;
		cp = new CoursePage(driver);
	}
	/**
	 * 点击立即购买按钮
	 * @throws IOException 
	 */
	public void clickBuyNow() throws IOException {
		cp.click(cp.getBuyCourseElement());
	}
	/**
	 * 点击添加购物车
	 * @throws IOException 
	 */
	public void clickAddCar() throws IOException {
		cp.click(cp.getAddShopCarElement());
	}
	/***
	 * 点击右上角购物车
	 * @throws IOException 
	 */
	public void clickShopCar() throws IOException {
		cp.click(cp.getShopCarElement());
	}
	/**
	 * 获取购物车数量
	 * @throws IOException 
	 */
	public String getCarNum() throws IOException {
		WebElement element = cp.getShopCarNumber();
		return cp.getText(element);
	}
	/***
	 * 获取课程名称
	 * @throws IOException 
	 */
	public String getCourse() throws IOException {
		WebElement element = cp. getCourseElement();
		return cp.getText(element);
	}
	
	/***
	 * 点击继续逛逛按钮 
	 */
	public void clickContinuePlay() throws IOException {
		cp.click(cp.getMotaiElement());
	}
}
