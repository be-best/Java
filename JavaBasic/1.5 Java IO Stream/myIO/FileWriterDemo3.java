package com.Brooke01;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 实现换行：
 *		"\r\n"
 *		windows:"\r\n"
 *		linux:"\n"
 *		mac:"\r" 
 * 实现追加写入数据：
 * 		FileWriter(String fileName,boolean append);
 * 
 */
public class FileWriterDemo3 {
	public static void main(String[] args) throws IOException {
		//创建输出流对象
		//FileWriter fw = new FileWriter("FileWriterDemo3.txt");
		
		//默认是false,为实现追加写入数据用true
		//运行一次追加一次
		FileWriter fw = new FileWriter("FileWriterDemo3.txt",true);		
		//实现换行
		for(int x=0;x<10;x++) {
			fw.write("helloworld"+x);
			fw.write("\r\n");
		}
		
		fw.close();
		

	}
}
