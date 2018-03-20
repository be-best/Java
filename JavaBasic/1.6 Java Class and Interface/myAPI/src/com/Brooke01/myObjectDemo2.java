package com.Brooke01;
/*
 * boolean equals(Object obj)
 * 重写equals方法
 */
public class myObjectDemo2 {
	public static void main(String[] args) {
		Students stu1 = new Students("张三",11);
		Students stu2 = new Students("张三",11);
		boolean flag = stu1.equals(stu2);
		System.out.println(flag);
	}
}

class Students {
	String name;
	int age;
	
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	//重写equals方法
	public boolean equals(Object obj) {
		//提高效率
		//比较地址值是否一样
		if(this == obj) {
			return true;
		}
		//判断地址值是否为空
		if(obj == null) {
			return false;
		}
		//提高代码健壮性
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		//向下转型
		Students stu = (Students) obj;
		//判断年龄
		if(age != stu.age) {
			return false;
		}
		if(name == null) {
			//判断姓名是否都为空
			if(this.name == null) {
				return true;
			}
			else {
				//判断姓名是否相同相同
				if(!name.equals(stu.name)) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
