package bull07.Annotations;

import java.lang.reflect.Method;

/*
 * 测试类
 */
public class TestDemo {
	public static void main(String[] args) throws Exception {
		//获取MyDemo类对象，并创建实例。
		Class clazz = MyDemo.class;
		Object obj = clazz.newInstance();
		
		
		//获取MyDemo中的所有方法
		Method[] allMethod = clazz.getMethods();
		
		for (Method method : allMethod) {
			//判断方法上是否有Mytest注释
			boolean b = method.isAnnotationPresent(MyTest.class);
			if(b) {
				method.invoke(obj);
			}

		}
	}
}
