package com.Brooke01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 学生信息管理系统
 */

public class StudentManager {
	public static void main(String[] args) throws IOException {
		//创建集合
		//ArrayList<Student> array = new ArrayList<Student>();
		String studentFile = "StudentFile.txt";
		while(true){
			System.out.println("------欢迎使用学生管理系统------");
			System.out.println("1 查看学生信息");
			System.out.println("2 添加学生信息");
			System.out.println("3 删除学生信息");
			System.out.println("4 修改学生信息");
			System.out.println("5 退出系统");
			System.out.println("请输入你的选择：");
			
			//输入选择号
			Scanner sc = new Scanner(System.in);
			String choiceStr = sc.nextLine();
			
			switch(choiceStr) {
			case "1":
				//查看学生信息
				findStudent(studentFile);
				break;
				
			case "2":
				//添加学生信息
				addStudent(studentFile);
				break;
				
			case "3":
				//删除学生信息
				delectStudent(studentFile);
				break;
				
			case "4":
				//修改学生信息
				updateStudent(studentFile);
				break;
				
			default:
				//退出
				System.out.println("谢谢您的使用！");
				System.exit(0);
				break;
			}
		}
		
	}
	
	//从文件中读取数据到集合中
	public static void readData(String studentFile,ArrayList<Student> array) throws IOException {
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader(studentFile));
		
		String line;
		while((line = br.readLine()) != null) {
			//分割字符串
			String[] strArray = line.split(",");
			Student stu = new Student();
			stu.setId(strArray[0]);
			stu.setName(strArray[1]);
			stu.setAge(strArray[2]);
			stu.setAddress(strArray[3]);
			
			//添加到集合中
			array.add(stu);
		}
		//释放资源
		br.close();
		
	}
	
	//把集合中的数据存储到文件中
	public static void writeData(String studentFile,ArrayList<Student> array) throws IOException {
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter(studentFile));
		
		for(int x=0;x<array.size();x++) {
			//链式编程
			Student stu = array.get(x);
			StringBuilder sb = new StringBuilder();
			sb.append(stu.getId()).append(",").append(stu.getName()).append(",").append(stu.getAge()).append(",").append(stu.getAddress());
			//将sb转化为字符串类型并写入文件
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//释放资源
		bw.close();
	}
	
	//查看学生信息
	public static void findStudent(String studentFile) throws IOException {
		//创建集合对象
		ArrayList<Student> array = new ArrayList<Student>();
		//从文件中把数据存到集合中
		readData(studentFile,array);
		if(array.size() == 0){
			System.out.println("对不起，暂无学生信息！");
		}
		else{
			System.out.println("学号\t姓名\t年龄\t地址");
			for(int x=0;x<array.size();x++) {
				//创建学生对象，获取学生信息
				Student stu = array.get(x);
				System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
				
			}
		}
	}
	
	//添加学生信息
	public static void addStudent(String studentFile) throws IOException {
		//创建集合对象
		ArrayList<Student> array = new ArrayList<Student>();
		//从文件中把数据存到集合中
		readData(studentFile,array);
		
		Scanner sc = new Scanner(System.in);
		String id;
		while(true) {
			System.out.println("请输入学生学号：");
			id = sc.nextLine();
			boolean flag = true;
			for(int x=0;x<array.size();x++) {
				Student stu = array.get(x);
				if(id.equals(stu.getId())) {
					flag = false;
					System.out.println("您输入的学号已经被占用，请重新输入！");
				}
				
			}
			if(flag == true) {
				break;
			}
		}
		
		System.out.println("请输入学生姓名：");
		String name = sc.nextLine();
		System.out.println("请输入学生年龄：");
		String age = sc.nextLine();
		System.out.println("请输入学生居住地：");
		String address = sc.nextLine();
		
		//创建学生对象，用set方法获取学生信息
		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setAge(age);
		stu.setAddress(address);
		
		//将学生对象存入集合中
		array.add(stu);
		
		//把集合中的数据写回文件中
		writeData(studentFile, array);
		
		System.out.println("添加成功！");
	}
	
	//删除学生信息
	public static void delectStudent(String studentFile) throws IOException {
		//创建集合对象
		ArrayList<Student> array = new ArrayList<Student>();
		//从文件中把数据存到集合中
		readData(studentFile,array);
		
		System.out.println("请输入你要删除的学生学号：");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int flag = -1;
		for(int x=0;x<array.size();x++) {
			//创建一个学生对象
			Student stu = array.get(x);
			if(id.equals(stu.getId())) {
				array.remove(x);
				flag = x;
			}
		}
		if(flag == -1){
			System.out.println("对不起，您输入的学号不存在！");
		}
		else {
			//把集合中的数据写回文件中
			writeData(studentFile, array);
			
			System.out.println("删除成功！");
		}
		
	}
	
	//修改学生信息
	public static void updateStudent(String studentFile) throws IOException {
		//创建集合对象
		ArrayList<Student> array = new ArrayList<Student>();
		//从文件中把数据存到集合中
		readData(studentFile,array);
		
		System.out.println("请输入你要修改的学生学号：");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int flag = -1;
		for(int x=0;x<array.size();x++) {
			Student stu = array.get(x);
			if(id.equals(stu.getId())) {
				flag = x;
				System.out.println("请输入新的学生学号：");
				String newId = sc.nextLine();
				System.out.println("请输入新的学生姓名：");
				String newName = sc.nextLine();
				System.out.println("请输入新的学生年龄：");
				String newAge = sc.nextLine();
				System.out.println("请输入新的学生居住地：");
				String newAddress = sc.nextLine();
				//更新学生信息
				stu.setId(newId);
				stu.setName(newName);
				stu.setAge(newAge);
				stu.setAddress(newAddress);
				//更新后的数据存入集合之中
				array.set(x,stu);
			}
			
		}
		if(flag == -1) {
			System.out.println("对不起，您输入的学生学号不存在！");
		}
		else {
			//把集合中的数据写回文件中
			writeData(studentFile, array);
			
			System.out.println("修改成功！");
		}
	}
}
