package com.Brooke05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 把文本文件中的信息读取出来存储到集合中，最后遍历集合，在控制台输出
 */
public class StudentTest1 {
	public static void main(String[] args) throws IOException {
		//创建输入缓冲流对象 
		BufferedReader br = new BufferedReader(new FileReader("StudentTest.txt"));
		
		//创建集合对象
		ArrayList<Student> array = new ArrayList<Student>();
		
		String line;
		while((line = br.readLine()) != null) {
			//分割字符串,分割后的元素存储到数组中,以","为分界点
			String[] strArray = line.split(",");
			Student stu = new Student();
			stu.setId(strArray[0]);
			stu.setName(strArray[1]);
			stu.setAge(strArray[2]);
			stu.setAddress(strArray[3]);
			
			array.add(stu);
		}
		
		//释放资源
		br.close();
		System.out.println("学号\t姓名\t年龄\t居住地");
		for(int x=0;x<array.size();x++) {
			Student stu = array.get(x);
			System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
		}
	}
}
