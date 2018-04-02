package bull04.Method;

import java.util.Arrays;

/*
 * JavaBean规范
 * 1.提供私有字段，例如：private String id;
 * 2.必须提供getter或setter方法
 * 3.提供无参构造方法
 * 4.必须实现序列化接口:
 * 			java.io.Serializable
 */
public class Bean implements java.io.Serializable {
	private String name;
	private int age;
	public String sex;
	
	public Bean() {
		System.out.println("调用了Bean的无参构造！");
	}
	
	public Bean(String name,int age) {
		System.out.println("调用了Bean的有参构造！");
		this.name = name;
		this.age = age;
	}
	
	private Bean(String name) {
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args) {
		//将指定的数组转换成字符串
		System.out.println(Arrays.toString(args));
	}

	private void show(int num) {
		System.out.println("私有方法："+num);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//重写toString方法
	@Override
	public String toString() {
		return "Bean [name=" + name + ", age=" + age + "]";
	}
	
	
}
