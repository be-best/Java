package bull04.Method;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * private���ͷ���
 */
public class PrivateMethod {
	@Test
	public void method () throws Exception {
		//1.��ȡʵ��
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//2.��ȡBean�е�˽�з���show
		Method showMethod = clazz.getDeclaredMethod("show", int.class);
		//3.ǿ���������з���˽�У�������
		showMethod.setAccessible(true);
		//4.ִ�з���
		Object r = showMethod.invoke(obj, 18);//���  ��˽�з�����18
		System.out.println(r);//�����null
		
	}
}
