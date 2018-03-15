package com.Brooke03;
/*
 * 运用字符缓冲流特殊功能复制文本
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamDemo4 {
	public static void main(String[] args) throws IOException {
		//新建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		
		//新建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("BufferedDemo4.txt"));
		
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine(); //换行
			bw.flush();
		}
		
		//释放资源
		br.close();
		bw.close();
	}
}
