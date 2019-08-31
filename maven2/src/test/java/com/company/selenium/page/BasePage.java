package com.company.selenium.page;
/**
 * 元素层（基类封装）
 * @author 61795
 *
 */

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.company.selenium.base.DriverBase;


public class BasePage {
	public DriverBase driver;//通过此处把两个类联系起来，
	
	
	//构造方法
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	/**
	 * 定位element,此处driver类型为DriverBase
	 * @param By by
	 */
	public WebElement element(By by) {
		WebElement element = driver.findElement(by);	
		return element;
	}
	/**
	 * 定位elements，
	 */
	public List<WebElement> elements(By by){
		List<WebElement> elements = driver.findElements(by);
		return elements;
		
	}
	/**
	 * 封装点击click
	 * @param WebElement element
	 */
	public void click(WebElement element) {
		if(element != null) {
			element.click();
		}else {
			System.out.println("元素没有定位到，点击失败");
		}		
	}
	/**
	 * 封装层级定位，通过父节点定位到子节点，需传入父节点和子节点的by
	 */
	public WebElement nodeElement(By by,By nodeby) {
		WebElement fatherEle = this.element(by);
		return fatherEle.findElement(nodeby);		
	}
	/**
	 * 封装输入sendKeys
	 * @param WebElement element,String value
	 */
	public void sendKeys(WebElement element,String value) {
		if(element != null) {
			element.sendKeys(value);
		}else {
			System.out.println("元素没有定位到，不能输入");
		}
	}
	/**
	 * 判断元素是否显示
	 * @param WebElement element
	 */
	public boolean assertElementIs(WebElement element) {
		return element.isDisplayed();
	}
	/**
	 * 封装获取文本
	 */
	public String getText(WebElement element) {
		return element.getText();
	}
	/**
	 * 封装切换窗口方法
	 */
	public void switchWindow() {
	
	}

}
