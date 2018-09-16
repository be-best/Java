package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CoreRunner {
	/**
	 * ��ò������Class.
	 * ���Class�е����еķ���.
	 * ����ÿ������,�鿴ÿ���������Ƿ���MyTestע��.
	 * ��MyTestע��,���������ִ��.
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
				//˵����������MyTestע��
				method.invoke(clazz.newInstance(), null);
			}
		}
	}
}
