package com.company.selenium.Case;

import java.io.IOException;

import org.apache.log4j.Logger;//注意log4j导入的包
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.company.selenium.base.DriverBase;
import com.company.selenium.business.CoursePro;
import com.company.selenium.business.LoginPro;
import com.company.selenium.business.MyShopCarPro;
import com.company.selenium.page.CoursePage;


/**
 * 测试用例
 * @author 61795
 *
 */
public class TestCase extends CaseBase{ //继承CaseBase类
	public DriverBase driver;
	public LoginPro loginpro;
	public CoursePro cpo;
	public MyShopCarPro mscp;
	//static Logger logger = Logger.getLogger(TestCase.class);//log4j
	public TestCase() {
		this.driver = initDriver("firefox");
		loginpro = new LoginPro(driver);
		cpo = new CoursePro(driver);
		mscp = new MyShopCarPro(driver);
	}
	/**
	 * 登录
	 * @throws InterruptedException 
	 */ 
	@Test
	public void enterLogin() throws InterruptedException{
		//logger.debug("这是打印的第一个日志======================");//打印日志
		driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");//此处get是DriverBase下封装的
		driver.maxWindow();
		Thread.sleep(500);
	}
	
	@Test(dependsOnMethods = {"enterLogin"})//依赖测试
	@Parameters({"username","password"})//testng参数化，从testng.xml里面拿参数
	public void testLogin(String username,String password) throws IOException { //把testng.xml里面拿到的参数传进来
		//logger.error("这是打印的第二个日志======================");		
		loginpro.login(username,password);		
	}
	/**
	 * 加入购物车
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dependsOnMethods= {"testLogin"})
	public void TestAddShopCar() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.get("https://coding.imooc.com/class/228.html");
		cpo.addCar();		
	}
	
	/**
	 * 添加到购物车，去购物车结算
	 */
	@Test(dependsOnMethods= {"TestAddShopCar"})
	public void topayMoney() throws InterruptedException, IOException {
		driver.switchWindow();//切换窗口，因为拿到的不是一个窗口
		Thread.sleep(1000);
		mscp.jieSuanButton();	
	}
	
}
