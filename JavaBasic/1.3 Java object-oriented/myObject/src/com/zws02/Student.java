package com.zws02;

public class Student {
	String name;
	 private int age;
	 public void setAge(int a) {
		 if(a<0 || a>200) {
			 System.out.println("你输入的年龄有误！");
		 }
		 else {
			 age = a;
		 }
	 }
	 
	 public int getAge() {
		 return age;
	 }
	
	 public void show() {
		 System.out.println("姓名是："+name+",年龄是："+age);
	 }
}
