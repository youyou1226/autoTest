/**
 * package com.company.selenium.util;为工具包
 */
package com.company.selenium.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.bcel.generic.NEW;



/**
 * 如何读取配置文件：load/setProperty/getProperty
 * 
 */
public class PropertiesUtil {
	//成员变量
	private Properties pp;
	private String filePath;
	
	/*public static void main(String[] args) throws IOException {
		PropertiesUtil pro = new PropertiesUtil("element.properties");
		System.out.println(pro.getPro("nameLocation"));
		System.out.println(pro.getPro("passwordLocation"));
		
	}*/
	//构造方法
	
	public PropertiesUtil(String filePath) {
		this.filePath = filePath;
		this.pp = readPro();
	}
	
	/**
	 * 读取配置文件
	 */
	private Properties readPro() {
		pp = new Properties();//实例化
		try {
			InputStream file = new FileInputStream(filePath);//读取文件,element.properties文件就在当前项目里
			BufferedInputStream in =new BufferedInputStream(file);//把文件放到缓存里面
			pp.load(in);//从缓存里面加载
		} catch (Exception e) {
			e.printStackTrace();
			}
		return pp;
	}
	/**
	 * 获取properties文件里面的值
	 */
	public String getPro(String key) throws IOException {
		if(pp.containsKey(key)) {
			String s =pp.getProperty(key);
			return s;
		}else {
			System.out.println("你获取的关键字不存在");
			return "";
		}		
	}
	/**
	 * 给properties文件里面写入东西
	 * @throws FileNotFoundException 
	 */
	public void writePro(String name,String value,String path,String domain)  {
		OutputStream file = null;
		PrintStream pStream = null;	
		try {
			file = new FileOutputStream(filePath);//写入的文件
			pStream = new PrintStream(file);
			String s = "name="+name+"\r\n"+"value="+value+"\r\n"+"path="+path+"\r\n"+"domain="+domain+"\r\n";
			pStream.print(s);		
		} catch (FileNotFoundException e) {
			pStream.close();
			e.printStackTrace();
		}
		
	}

}
