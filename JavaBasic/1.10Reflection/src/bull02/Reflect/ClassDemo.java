package bull02.Reflect;

import org.junit.Test;

/*
 * Java提供三种方式获得Class对象
 * 不同的应用场景需要不同的方式获得Class对象	
 * 
 * 方式：
 * 1.通过字符串（全限定类名）获得
 * 		格式：Class clazz	 = Class.forName("字符串");
 * 		全限定类名：包名+类名
 *   应用场景：确定类型等
 * 			
 * 2.通过Java类型获得
 * 		格式：Class clazz = 类型.class;
 *   应用场景：在方法内部通过参数获得类型等
 *   
 * 3.通过实例对象获得
 * 		格式：Class clazz = obj.getClass();
 *   应用场景：通过配置获得字符串等
 */
public class ClassDemo {
	
	@Test
	public void demo1() throws ClassNotFoundException {
		Class clazz = Class.forName("bull02.Reflect.Bean");
		System.out.println(clazz);
	}
	
	@Test
	public void demo2() {
		Class clazz = Bean.class;
		System.out.println(clazz);
	}
	
	@Test
	public void demo3() {
		Bean be = new Bean();
		Class clazz = be.getClass();
		System.out.println(clazz);
	}
}
