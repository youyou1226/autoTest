package com.company.selenium.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.cookie.CookieSpec;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import com.company.selenium.base.DriverBase;



public class HandleCookie {
	public DriverBase driver;
	public Cookie cookie;
	public PropertiesUtil pul;
	public HandleCookie(DriverBase driver) throws IOException {
		this.driver = driver;
		pul = new PropertiesUtil("cookie.properties");
				
	}
	public void addCookie() throws IOException, InterruptedException {	
		//cookie = new Cookie(pul.getPro("name"),pul.getPro("value"),pul.getPro("domain"),pul.getPro(" path"), null);
		cookie = new Cookie(pul.getPro("name"),pul.getPro("value"));
		Thread.sleep(2000);
		driver.addCookie(cookie);
		Thread.sleep(2000);			
	}
	/**
	 * 写入cookie
	 * @return
	 */
	public void writeCookie() {
		Set<Cookie> cookies = driver.getCookies();
		for(Cookie ck:cookies) {
			if(ck.getName().equals("apsid")) {
				System.out.println(ck.getName()+Keys.TAB+ck.getValue()+Keys.TAB+ck.getDomain()+Keys.TAB+ck.getPath()+Keys.TAB+ck.getExpiry());
				pul.writePro(ck.getName(),ck.getValue(),ck.getPath(),ck.getDomain());//给文件中写入东西，调用PropertiesUtil的writePro方法
				break;
			}
		}
		/*Iterator<Cookie> iterator = cookies.iterator();
		while(iterator.hasNext()) {
			Cookie ck = iterator.next();
			System.out.println(ck.getName()+Keys.TAB+ck.getValue()+Keys.TAB+ck.getDomain()+Keys.TAB+ck.getPath()+Keys.TAB+ck.getExpiry());
		}*///打印出所有cookie
	}
}