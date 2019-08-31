package com.company.selenium.Case;
/**
 * 企业中case的应用，涉及登录才能进行下一步操作，绕过cookie登录
 * @author 61795
 *
 */

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.company.selenium.base.DriverBase;
import com.company.selenium.business.CoursePro;
import com.company.selenium.business.MyShopCarPro;
import com.company.selenium.util.HandleCookie;
import com.company.selenium.util.PropertiesUtil;

public class SuitTestShopCar extends CaseBase{
	public DriverBase driver;
	public CoursePro cpo;
	public MyShopCarPro mscp;
	public HandleCookie handleCookie;
	public PropertiesUtil pul;
	@BeforeClass
	public  void beforeClass() throws IOException {
		this.driver = initDriver("firefox");//一定要初始化driver，initDriver是CaseBase里面的方法
		cpo = new CoursePro(driver);
		mscp = new MyShopCarPro(driver);
		handleCookie = new HandleCookie(driver);
		pul = new PropertiesUtil("element.properties");
	}
	@AfterClass
	public  void afterClass() {
		driver.closeBrowser();
	}
	/**
	 * cookie是先用抓包工具得到cookie，写入cookie.properties文件，再读取出来；或者用程序写，先登录一次，把得到的cookie写到cookie.properties文件，再读取出来
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testShop() throws IOException, InterruptedException {
		driver.get(pul.getPro("url"));
		handleCookie.addCookie();
		driver.refrsh();//刷新页面
		Thread.sleep(2000);	
		driver.maxWindow();
		cpo.addCar();	
		Thread.sleep(2000);
		driver.switchWindow();//切换窗口，因为拿到的不是一个窗口
		Thread.sleep(1000);
		mscp.jieSuanButton();
	}
	
}
