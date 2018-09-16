package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CoreRunner {
	/**
	 * 获得测试类的Class.
	 * 获得Class中的所有的方法.
	 * 遍历每个方法,查看每个方法上是否有MyTest注解.
	 * 有MyTest注解,这个方法就执行.
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = AnnotationDemo1.class;
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			boolean flag = method.isAnnotationPresent(MyTest.class);
			if(flag == true) {
				//说明方法上有MyTest注解
				method.invoke(clazz.newInstance(), null);
			}
		}
	}
}
