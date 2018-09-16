package bull03.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectDemo1 {
	@Test
	/**
	 * ��ô����������ص��ڴ���ֽ����ļ���class����
	 */
	public void demo1() throws Exception {
		//1.ͨ��	����.class
		Class clazz1 = Person.class;
		//2.ͨ�����ʵ������  .getClass()�������
		Person p = new Person();
		Class clazz2 = p.getClass();
		//3.ʹ��Class��forName��̬�������
		Class clazz3 = Class.forName("bull03.reflect.Person");
	}
	
	@Test
	/**
	 * ͨ����������乹�췽��
	 */
	public void demo2() throws Exception {
		Class clazz = Class.forName("bull03.reflect.Person");
		//���ʵ��������,Ĭ�ϵ��޲����Ĺ��췽���Ĵ���
		Person person = (Person) clazz.newInstance();
		
		//�����вεķ�����������
		Constructor c = clazz.getConstructor(String.class,Integer.class);
		Person p = (Person) c.newInstance("����",20);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
	}
	
	@Test
	/**
	 * ͨ�����������е�����
	 */
	public void demo3() throws Exception {
		Class clazz = Class.forName("bull03.reflect.Person");
		//��ù�������
		//clazz.getField("name");//���ĳ������
		//clazz.getFields();//�����������
		
		//���˽������
		Field field1 = clazz.getDeclaredField("name");
		field1.setAccessible(true);
		
		Field field2 = clazz.getDeclaredField("age");
		field2.setAccessible(true);
		
		Constructor c = clazz.getConstructor(String.class,Integer.class);
		Person p = (Person) c.newInstance("��˹",10);
		
		String name = (String) field1.get(p);
		Integer age = (Integer) field2.get(p);
		
		System.out.println(name);
		System.out.println(age);
	}
	
	@Test
	/**
	 * ͨ������������еķ���
	 */
	public void demo4() throws Exception {
		Class clazz = Class.forName("bull03.reflect.Person");
		Method method1 = clazz.getDeclaredMethod("run");
		method1.setAccessible(true);
		method1.invoke(clazz.newInstance());
		
		Method method2 = clazz.getDeclaredMethod("eat", String.class);
		method2.setAccessible(true);
		method2.invoke(clazz.newInstance(), "ˮ��");
		
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
			 
			 
			 Servlet�������̣�
			 Class clazz = Clazz.forName("bull01.VisitTime.UserCountServlet");
			 Method method = clazz.getDeclaredMethod("service","HttpServletrequest.class","HttpServletresponse,class");
			 method.invoke("clazz.newInstance()",request,response);
		 */
	}
	
}









