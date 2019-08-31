package com.company.selenium.Case;

/**
 * 企业中case的应用，一条case一个类
 * @author 61795
 *
 */
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.company.selenium.base.DriverBase;

import com.company.selenium.business.LoginPro;
import com.company.selenium.business.PersionalInforPro;
import com.company.selenium.util.HandleCookie;
import com.company.selenium.util.PropertiesUtil;
public class SuitTestLogin extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public PersionalInforPro pifPage;//断言时要用
	public PropertiesUtil pul;//自己写的工具包里面读取配置文件
	public HandleCookie handleCookie;
	//不用构造方法了,使用TestNG注解
	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		this.driver = initDriver("firefox");//一定要初始化driver，initDriver是CaseBase里面的方法
		loginpro = new LoginPro(driver);
		pifPage = new PersionalInforPro(driver);		
		pul = new PropertiesUtil("login.properties");//login.properties为项目工程路径下的文件
		handleCookie = new HandleCookie(driver);
		
		String url = pul.getPro("url");
		driver.get(url);//此处get是DriverBase下封装的
		driver.maxWindow();
		Thread.sleep(500);		
	}
	@Test
	public void testLogin() throws IOException, InterruptedException {
		driver.deleteAllCookie();//登录前先删除所有cookies
		
		String username = pul.getPro("username");
		String password = pul.getPro("password");
		loginpro.login(username, password);
		Thread.sleep(2000);
		String expect = pul.getPro("yuqi");//预期值
		String actural = pifPage.getText();//
		System.out.println(expect);
		System.out.println(actural);
		Thread.sleep(2000);
		if(pifPage.AssertLogin(expect)) {
			System.out.println("登录成功"+actural);
			Thread.sleep(5000);			
			handleCookie.writeCookie();//登录成功后调用HandleCookie把cookie写进去			
		}else {
			System.out.println("登录失败");
		}
		
		
	}
	//@AfterClass
	public void afterClass() {
		driver.closeBrowser();
	}
}
