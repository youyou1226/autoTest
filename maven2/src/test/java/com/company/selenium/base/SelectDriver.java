package com.company.selenium.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 * driver封装
 * @author 61795
 *
 */
public class SelectDriver {
	public WebDriver driver;
	public WebDriver driverName(String browser) {		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.bin", "E:\\Soft\\firefox.exe");//如果死默认路径安装，不需要设置
			//System.setProperty("webdriver.gecko.driver", "F:\\caojinfeng\\driver\\geckodriver.exe");//如果环境变量配置了则不要设置
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");			
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "F:\\caojinfeng\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;		
	}

}
