package maven2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ReadWrite {
	@Test
	public void readFileToList2() {
		File file = new File("f:\\1.txt");
		System.out.println("文件绝对路径 :"+file.getAbsolutePath());
		List<String> listStr = new ArrayList<String>();
		BufferedReader br = null;
		String str = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine())!= null) {
				listStr.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listStr);
		writeListToFile(listStr);// 调用写操作方法
	}
 
	/**
	 * 实现写操作方法
	 */
	private void writeListToFile(List<String> listStr) {
		File file = new File("f:\\3.properties");// 要写入的文件路径
		if (!file.exists()) {// 判断文件是否存在
			try {
				file.createNewFile();// 如果文件不存在创建文件
				System.out.println("文件"+file.getName()+"不存在已为您创建!");
			} catch (IOException e) {
				System.out.println("创建文件异常!");
				e.printStackTrace();
			}
		} else {
			System.out.println("文件"+file.getName()+"已存在!");
		}
		
		for (String str : listStr) {// 遍历listStr集合
			FileOutputStream fos = null;
			PrintStream ps = null;
			try {
				fos = new FileOutputStream(file,true);// 文件输出流	追加
				ps = new PrintStream(fos);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String string  = str + "\r\n";// +换行
			ps.print(string); // 执行写操作
			ps.close();	// 关闭流
			
		}
		
		System.out.println("文件写入完毕!");
	}


}
