package com.Brooke05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 读取文本数据存到集合中并遍历集合
 */
public class FileToArrayListTest {
	public static void main(String[] args) throws IOException {
		//创建集合对象
		ArrayList<String> array = new ArrayList<String>();
		
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader("ArrayListToFileTest.txt"));
		
		String line;
		while((line = br.readLine()) != null) {
			array.add(line);
		}
		
		//释放资源
		br.close();
		
		for(int x=0;x<array.size();x++) {
			System.out.println(array.get(x));
		}
	}

}
