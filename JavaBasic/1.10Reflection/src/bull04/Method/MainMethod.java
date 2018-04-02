package bull04.Method;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * main方法
 */
public class MainMethod {
	@Test
	public void method() throws Exception {
		//1.获取Class对象，main方法是静态方法所以不需要获取实例
		Class clazz = Class.forName("bull04.Method.Bean");
		
		//2.获取main方法
		Method mainMethod = clazz.getMethod("main", String[].class);	
		
		//3.执行main方法
		/*
		 * 参数1：为实例对象（变量名），static方法不需要实例
		 * 参数2：main方法执行时的实际参数
		 * 可变参数在执行时，JVM内部将传递实参数组打散,变成多个参数
		 * 		method.invoke(null,args);
		 * 		method.invoke(null,"abc","123","xxx");
		 */
		String[] args = {"abc","123","xxx"};
		//mainMethod.invoke(null, args);//错误写法
		//3.1执行方式一：将String转换为Object，可变参数将不处理数组
		mainMethod.invoke(null, (Object)args);
		//3.2执行方式二：提供二维数组，args将作为二维数组的第一个数
		mainMethod.invoke(null, new Object[] {args});
	}
}
