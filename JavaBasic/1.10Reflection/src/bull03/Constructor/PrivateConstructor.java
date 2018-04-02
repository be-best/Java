package bull03.Constructor;

import java.lang.reflect.Constructor;

import org.junit.Test;

/*
 * ͨ��˽�й��촴��ʵ��������
 * 1.���Class����
 * 2.���ָ���β� ˽�й���
 * 3.֪ͨJVM������ʵ����˽�й��죨Ĭ�ϲ�����
 * 4.����ʵ����������ʵ������	
 */
public class PrivateConstructor {
	@Test
	public void method() throws Exception {
		//���Class����
		Class clazz = Class.forName("bull03.Constructor.Bean");
		//���ָ���β� ˽�й���
		//clazz.getConstructor(...);���ָ�������ָ����public���췽��
		//clazz.getDeclaredConstructor(...);���ָ�������ָ�������⹹�췽��
		Constructor cons = clazz.getDeclaredConstructor(String.class); 
		//֪ͨJVM������ʵ����˽�й��죨Ĭ�ϲ�����
		cons.setAccessible(true);
		//����ʵ����������ʵ������	
		Object obj = cons.newInstance("aaa");
		System.out.println(obj);
	}
}
