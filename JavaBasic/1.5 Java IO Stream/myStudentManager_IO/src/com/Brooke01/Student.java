package com.Brooke01;

public class Student {
	private String name; //姓名
	private String id;  //学号
	private String age;	//年龄
	private String address;	//居住地
	
	public Student() {
	
	}

	public Student(String name, String id, String age, String address) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
