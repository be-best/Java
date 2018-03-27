package bull1714.ObjectStream;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 解决对实现序列化接口出现的黄色警告问题
	 * 添加了序列号后添加/删除成员变量不会出错
	 */
	private static final long serialVersionUID = 844933104622211505L;
	
	String name;
	int age;
	
	public Student() {
		
	}
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	//重写toString方法
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}
