package com.Brooke03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 输入输出缓冲流的特殊功能
 * BufferedWriter：
 * 		void newLine(); 换行
 * BufferedReader:
 * 		String readLine(); 读取一行数据，不读取换行符
 */
public class BufferedStreamDemo3 {
	public static void main(String[] args) throws IOException {
		//创建数出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("BUfferedDemo3.txt"));
		
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader("helloworld.txt"));
		
		//void newLine();
		for(int x=0;x<10;x++) {
			bw.write("helloworld"+x);
			bw.newLine(); //换行
			bw.flush();
		}
		
		//String readLine();
		//读取一行数据，不读取换行符
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		//释放资源
		bw.close();
		br.close();
	}
}
