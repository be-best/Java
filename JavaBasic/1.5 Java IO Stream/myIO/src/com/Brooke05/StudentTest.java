package com.Brooke05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 键盘录入学生信息存入集合，遍历集合把学生信息存入文本(定义分割标记)
 */
public class StudentTest {
	public static void main(String[] args) throws IOException {
		//创建结集合对象
		ArrayList<Student> array = new ArrayList<Student>();
		for(int x=0;x<3;x++) {
			addStudent(array);
		}
		
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("StudentTest.txt"));
		
		for(int x=0;x<array.size();x++) {
//			String id = array.get(x).getId();
//			bw.write(id+",");
//			String name = array.get(x).getName();
//			bw.write(name+",");
//			String age = array.get(x).getAge();
//			bw.write(age+",");
//			String address = array.get(x).getAddress();
//			bw.write(address);
//			bw.newLine();
			
			Student stu = array.get(x);
			//链式编程
			StringBuilder sb = new StringBuilder();
			sb.append(stu.getId()).append(",").append(stu.getName()).append(",").append(stu.getAge()).append(",").append(stu.getAddress());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//释放资源
		bw.close();
		
	}
	
	//添加学生
	public static void addStudent(ArrayList<Student> array) {
		Scanner sc = new Scanner(System.in);
		String id = "";
		while(true) {
			System.out.println("请输入学号：");
			id = sc.nextLine();
			boolean flag = true;
			for(int x=0;x<array.size();x++) {
				if(id.equals(array.get(x).getId())) {
					System.out.println("您输入的学号已经被占用，请重新输入！");
					flag = false;
				}
			}
			if(flag == true) {
				break;
			}
		}
		System.out.println("请输入姓名：");
		String name = sc.nextLine();
		System.out.println("请输入年龄：");
		String age = sc.nextLine();
		System.out.println("请输入居住地：");
		String address = sc.nextLine();
		
		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setAge(age);
		stu.setAddress(address);
		
		array.add(stu);
	}
}
