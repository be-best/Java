package bull05.Field;

import java.lang.reflect.Field;

import org.junit.Test;

/*
 * private˽���ֶ�
 */
public class PrivateField {
	@Test
	public void privateField() throws Exception {
		//1.��ȡʵ��
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//2.���ֶθ�ֵ
		Field field = clazz.getDeclaredField("name");
		
		//2.1�������з���˽�У�������
		field.setAccessible(true);
		//2.2�ȱ����ٸ�ֵ
		field.set(obj, "����");
		
		//3.��ȡ�ֶ�ֵ
		String name = (String) field.get(obj);
		System.out.println(name);
	}
}
