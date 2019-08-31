package com.company.selenium.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.selenium.util.PropertiesUtil;



/**
 * 基类封装
 * @author 61795
 *
 */
public class DriverBase {
	public WebDriver driver;
	public static By byReturn;
	/*构造方法*/
	public DriverBase(String browser) {
		SelectDriver sd = new SelectDriver();
		driver = sd.driverName(browser);
	}
	
	public void closeBrowser() {
		//driver.close();//关闭当前窗口
		driver.quit();//全部关闭
	}
	
	/**
	 * 定位Element，此处driver类型为WebDriver
	 * @param By by
	 */
	public WebElement findElement(By by) {
		WebElement  element = driver.findElement(by);
		
		return element;
	}
	
	/**
	 * 封装Elements
	 */
	public List<WebElement> findElements(By by) {
		List<WebElement> elements = driver.findElements(by);
		return elements;
	}
	
	/**
	 * 封装get
	 * @param url
	 */
	public void get(String url) {
		driver.get(url);
	}
	/**
	 * 封装窗口最大化
	 */
	public void maxWindow() {
		driver.manage().window().maximize();
	}
	/**
	 * 切换alert窗口
	 */
	public void alert() {
		driver.switchTo().alert();
	}
	/**
	 * 切换windows窗口
	 * @throws InterruptedException 
	 */
	public void switchWindow1() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();
		for (String s:handles) {
			driver.switchTo().window(s);
			Thread.sleep(1000);
		}
	}
	/**
	 * 窗口切换：发散思维：拿到一个窗口，存储；点击拿到另一个窗口，存储所有；两次拿到对比，如果一样就不切换，否则切换
	 */
	public void switchWindow() throws InterruptedException {
		String h = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String s:handles) {
			if(h.equals(s)) {
				continue;
			}
			driver.switchTo().window(s);
			Thread.sleep(1000);
		}
	}
	/**
	 * 模态框切换
	 */
	public void switchToMotai() {
		driver.switchTo().activeElement();//模态框
	}
	/**
	 * 封装By
	 * @throws IOException 
	 */
	//设置为静态的可用方法名调用，不用new对象
	public static  By byStr(String ss) throws IOException { 
		//读取配置文件
		PropertiesUtil pro = new PropertiesUtil("element.properties");		
		String localType = pro.getPro(ss).split(">")[0];//定位方式
		String localValue = pro.getPro(ss).split(">")[1];//定位值
		if(localType.equals("name")) {
			byReturn = By.name(localValue);
		}else if(localType.equals("id")) {
			 byReturn = By.id(localValue);
		}else if(localType.equals("tagName")) {
			 byReturn = By.tagName(localValue);
		}else if(localType.equals("className")){
			 byReturn = By.className(localValue);
		}else if(localType.equals("xpath")) {
			 byReturn = By.xpath(localValue);
		}
		 return byReturn;
	}
	
	/**
	 * 返回
	 */
	public void  back() {
		driver.navigate().back();
	}
	/**
	 * 添加cookie
	 */
	public void addCookie(Cookie cookie) {
		driver.manage().addCookie( cookie);
		
	}
	/**
	 * 删除cookies
	 */
	public void deleteAllCookie() {
		driver.manage().deleteAllCookies();
	}
	/**
	 * 得到cookie
	 */
	public Set<Cookie> getCookies() {
		  Set<Cookie> cookies = driver.manage().getCookies();		 
		return cookies;
		 
	}
	/**
	 * 刷新页面
	 */
	public void refrsh() {
		driver.navigate().refresh();
	}
	/**
	 * 获取所有课程的list（遍历课程实战）
	 * @throws IOException 
	 */
	public List<String> courseList() throws IOException{
		List<String> list = new ArrayList<String>();
		List<WebElement> elements =  driver.findElements(byStr("courselist2"));	
		for(WebElement w:elements) {
			String str = driver.findElement(By.className("shizan-desc")).getText();//获取文字
			list.add(str);
		}
		return list;
	}
	
	/**
	 * js封装（js改变css）
	 * 
	 */
	public void jsExecute(String css) {		
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;		 
		jsDriver.executeScript(css);
		
	}
}
