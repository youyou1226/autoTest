package com.company.selenium.business;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.company.selenium.base.DriverBase;
import com.company.selenium.handle.CoursePageHandle;

public class CoursePro {
	public CoursePageHandle cph;
	public DriverBase driver;
	
	public CoursePro(DriverBase driver) {
		this.driver = driver;
		cph = new CoursePageHandle(driver);
	} 
	/**
	 * 添加购物车
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public void addCar() throws IOException, InterruptedException {
		int beforeNum;
		int afterNum ;
		String courseNum = cph.getCarNum();
		try {			
			beforeNum = Integer.valueOf(courseNum);//转换成整型数据,购物车为空时不能转换
		} catch (Exception e) {
			beforeNum = 0;
		}
		
		cph.clickAddCar();//点击“加购物车按钮”
		Thread.sleep(1000);//一定要等
		//driver.switchToMotai();//此处不是alert，模态框不用switchto
		
			try {
				 cph.clickContinuePlay();//弹框可能出现，可能不出现
			} catch (Exception e) {
				System.out.println("购物车为空");
			}

		Thread.sleep(3000);//一定要等
		String afterCourseNum = cph.getCarNum();//再次获取
		Thread.sleep(2000);
		try {
			afterNum = Integer.valueOf(afterCourseNum);
		} catch (Exception e) {
			afterNum = beforeNum;
		}
		System.out.println(afterNum);
		System.out.println(beforeNum);
		Thread.sleep(3000);
		if(afterNum == beforeNum+1) {
			cph.clickShopCar();//点击右上角购物车
			System.out.println("添加购物车成功");
		}else if(afterNum>0) {
			cph.clickShopCar();			
		}
		Thread.sleep(2000);
		
	}
}
