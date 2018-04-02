package bull04.Method;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * public类型方法
 */
public class PublicMethod {
	@Test
	public void method1() {
		Bean be = new Bean();
		be.setName("aaa");
		be.setAge(10);
		String name = be.getName();
		int age = be.getAge();
		System.out.println(name+"---"+age);
	}
	
	//用反射实现上述方法
	@Test
	public void method2() throws Exception {
		//1.获取实例
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//2.通过获取Bean中的set方法设置数据
		//2.1获得方法,需要明确形参列表（String.class）;
		//获取设置姓名方法setName
		Method methodSetName = clazz.getMethod("setName", String.class);
		//获取设置年龄方法setAge
		Method methodSetAge = clazz.getMethod("setAge", int.class);
		
		//2.2执行方法
		//确定实例对象，并执行确定方法，具体实际参数。
		//invoke可以理解为执行的意思
		methodSetName.invoke(obj, "aaa");//设置姓名
		methodSetAge.invoke(obj, 10);//设置年龄
		
		System.out.println(obj);
	}
	
	//在method2的基础上，用get方法获取数据
		@Test
		public void method3() throws Exception {
			//1.获取实例
			Class clazz = Class.forName("bull04.Method.Bean");
			Object obj = clazz.newInstance();
			
			//2.通过获取Bean中的set方法设置数据
			//2.1获得方法,需要明确形参列表（String.class）;
			//获取设置姓名方法setName
			Method methodSetName = clazz.getMethod("setName", String.class);
			//获取设置年龄方法setAge
			Method methodSetAge = clazz.getMethod("setAge", int.class);
			
			//2.2执行方法
			//确定实例对象，并执行确定方法，具体实际参数。
			//invoke可以理解为执行的意思
			methodSetName.invoke(obj, "aaa");//设置姓名
			methodSetAge.invoke(obj, 10);//设置年龄
			
			//3.通过get方法获取数据
			//分别获取用来获取姓名和年龄的getName和getAge方法
			//需要注意的是get方法没有形式参数！！！所以不用指定形参类型。
			Method methodGetName = clazz.getMethod("getName");
			Method methodGetAge = clazz.getMethod("getAge");
			
			//invoke返回的是object对象，所以要进行强制装换。invoke后面括号不用指定参数。
			String str = (String) methodGetName.invoke(obj);
			int age = (int) methodGetAge.invoke(obj);
			
			System.out.println(str+"---"+age);
		}
}
