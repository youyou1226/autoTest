package com.company.selenium.Case;
/**
 * 遍历实战课程
 * @author 61795
 *
 */

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.selenium.base.DriverBase;






public class TestCourseList extends CaseBase{
	public  DriverBase driver;
	
	public TestCourseList() {
		 driver = initDriver("firefox");
	 }
	@Test
	public void courseList() throws IOException, InterruptedException {
			 driver.get("https://coding.imooc.com/");
			 Thread.sleep(500);
			 driver.maxWindow();
			 Thread.sleep(500);
			 driver.findElement(By.xpath("html/body/a/i")).click();//每次页面弹出前有个新人大礼窗口，先关闭
			 Thread.sleep(500);
			 List list = driver.courseList();//调用DriverBase里面方法
			 Thread.sleep(2000);
			 for(int i=0;i<list.size();i++) {
				driver.findElement(By.xpath(".//*[contains(text(),'"+list.get(i)+"')]")).click();//此处对照：.//*[contains(text(),' 大神带你从入门到精通（bobo老师爆款）')]
				Thread.sleep(500);
				driver.back();//此处webdriver不配套，不能用导航
				Thread.sleep(500);
				driver.findElement(By.xpath("html/body/a/i")).click();//每次页面弹出前有个新人大礼窗口，先关闭
				Thread.sleep(500);
			}
		 }	
}
