package com.Brooke01;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 学生信息管理系统
 */
public class StudenManager {
	public static void main(String[] args) {
		//创建集合
		ArrayList<Student> array = new ArrayList<Student>();
		
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
				findStudent(array);
				break;
				
			case "2":
				//添加学生信息
				addStudent(array);
				break;
				
			case "3":
				//删除学生信息
				delectStudent(array);
				break;
				
			case "4":
				//修改学生信息
				updateStudent(array);
				break;
				
			default:
				//退出
				System.out.println("谢谢您的使用！");
				System.exit(0);
				break;
			}
		}
		
	}
	//查看学生信息
	public static void findStudent(ArrayList<Student> array) {
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
	public static void addStudent(ArrayList<Student> array) {
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
		System.out.println("添加成功！");
	}
	
	//删除学生信息
	public static void delectStudent(ArrayList<Student> array) {
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
			System.out.println("删除成功！");
		}
		
	}
	
	//修改学生信息
	public static void updateStudent(ArrayList<Student> array) {
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
			System.out.println("修改成功！");
		}
	}
}
