package bull03.Constructor;
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
	
	
}
