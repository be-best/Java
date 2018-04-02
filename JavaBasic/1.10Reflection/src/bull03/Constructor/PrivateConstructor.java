package bull03.Constructor;

import java.lang.reflect.Constructor;

import org.junit.Test;

/*
 * 通过私有构造创建实例化对象
 * 1.获得Class对象
 * 2.获得指定形参 私有构造
 * 3.通知JVM，运行实例化私有构造（默认不允许）
 * 4.创建实例，并设置实例参数	
 */
public class PrivateConstructor {
	@Test
	public void method() throws Exception {
		//获得Class对象
		Class clazz = Class.forName("bull03.Constructor.Bean");
		//获得指定形参 私有构造
		//clazz.getConstructor(...);获得指定对象的指定的public构造方法
		//clazz.getDeclaredConstructor(...);获得指定对象的指定的任意构造方法
		Constructor cons = clazz.getDeclaredConstructor(String.class); 
		//通知JVM，运行实例化私有构造（默认不允许）
		cons.setAccessible(true);
		//创建实例，并设置实例参数	
		Object obj = cons.newInstance("aaa");
		System.out.println(obj);
	}
}
