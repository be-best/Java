package bull04.Method;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * private类型方法
 */
public class PrivateMethod {
	@Test
	public void method () throws Exception {
		//1.获取实例
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//2.获取Bean中的私有方法show
		Method showMethod = clazz.getDeclaredMethod("show", int.class);
		//3.强制设置运行访问私有（暴力）
		showMethod.setAccessible(true);
		//4.执行方法
		Object r = showMethod.invoke(obj, 18);//输出  ：私有方法：18
		System.out.println(r);//输出：null
		
	}
}
