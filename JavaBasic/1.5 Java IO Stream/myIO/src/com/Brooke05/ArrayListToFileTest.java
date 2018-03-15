package com.Brooke05;
/*
 * 把ArrayLit集合中的字符数据存储到文本内
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToFileTest {
	public static void main(String[] args) throws IOException {
		//创建集合对象
		ArrayList<String> array = new ArrayList<String>();
		
		//往集合中添加元素
		array.add("hello");
		array.add("world");
		array.add("java");
		
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("ArrayListToFileTest.txt"));
		
		for(int i=0;i<array.size();i++) {
			String line = array.get(i);
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//释放资源
		bw.close();
	}
}
