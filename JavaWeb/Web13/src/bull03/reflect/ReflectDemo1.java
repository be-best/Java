package bull03.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectDemo1 {
	@Test
	/**
	 * 获得代表这个类加载到内存的字节码文件的class对象
	 */
	public void demo1() throws Exception {
		//1.通过	类名.class
		Class clazz1 = Person.class;
		//2.通过类的实例对象  .getClass()方法获得
		Person p = new Person();
		Class clazz2 = p.getClass();
		//3.使用Class的forName静态方法获得
		Class clazz3 = Class.forName("bull03.reflect.Person");
	}
	
	@Test
	/**
	 * 通过反射操作其构造方法
	 */
	public void demo2() throws Exception {
		Class clazz = Class.forName("bull03.reflect.Person");
		//获得实例化对象,默认的无参数的构造方法的创建
		Person person = (Person) clazz.newInstance();
		
		//采用有参的方法创建对象
		Constructor c = clazz.getConstructor(String.class,Integer.class);
		Person p = (Person) c.newInstance("张三",20);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
	}
	
	@Test
	/**
	 * 通过反射获得类中的属性
	 */
	public void demo3() throws Exception {
		Class clazz = Class.forName("bull03.reflect.Person");
		//获得公有属性
		//clazz.getField("name");//获得某个属性
		//clazz.getFields();//获得所有属性
		
		//获得私有属性
		Field field1 = clazz.getDeclaredField("name");
		field1.setAccessible(true);
		
		Field field2 = clazz.getDeclaredField("age");
		field2.setAccessible(true);
		
		Constructor c = clazz.getConstructor(String.class,Integer.class);
		Person p = (Person) c.newInstance("里斯",10);
		
		String name = (String) field1.get(p);
		Integer age = (Integer) field2.get(p);
		
		System.out.println(name);
		System.out.println(age);
	}
	
	@Test
	/**
	 * 通过反射操作类中的方法
	 */
	public void demo4() throws Exception {
		Class clazz = Class.forName("bull03.reflect.Person");
		Method method1 = clazz.getDeclaredMethod("run");
		method1.setAccessible(true);
		method1.invoke(clazz.newInstance());
		
		Method method2 = clazz.getDeclaredMethod("eat", String.class);
		method2.setAccessible(true);
		method2.invoke(clazz.newInstance(), "水果");
		
		/**
		 *   <servlet>
			    <servlet-name>UserCountServlet</servlet-name>
			    <display-name>This is the display name of my J2EE component</display-name>
			    <description>This is the description of my J2EE component</description>
			    <servlet-class>bull01.VisitTime.UserCountServlet</servlet-class>
			  </servlet>
			 
			<servlet-mapping>
			    <servlet-name>UserCountServlet</servlet-name>
			    <url-pattern>/UserCountServlet</url-pattern>
			  </servlet-mapping>
			 
			 
			 Servlet反射流程：
			 Class clazz = Clazz.forName("bull01.VisitTime.UserCountServlet");
			 Method method = clazz.getDeclaredMethod("service","HttpServletrequest.class","HttpServletresponse,class");
			 method.invoke("clazz.newInstance()",request,response);
		 */
	}
	
}









