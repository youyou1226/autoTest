package com.company.selenium.Case;
/**
 * 生成driver，所有的测试类都继承该类拿到driver
 * @author 61795
 *
 */

import com.company.selenium.base.DriverBase;

public class CaseBase {
	
	public DriverBase initDriver(String browser) {
		return new DriverBase(browser);
	}
}
