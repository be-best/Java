package bull07.Annotations;

import java.lang.reflect.Method;

/*
 * ������
 */
public class TestDemo {
	public static void main(String[] args) throws Exception {
		//��ȡMyDemo����󣬲�����ʵ����
		Class clazz = MyDemo.class;
		Object obj = clazz.newInstance();
		
		
		//��ȡMyDemo�е����з���
		Method[] allMethod = clazz.getMethods();
		
		for (Method method : allMethod) {
			//�жϷ������Ƿ���Mytestע��
			boolean b = method.isAnnotationPresent(MyTest.class);
			if(b) {
				method.invoke(obj);
			}

		}
	}
}
