package bull05.Field;
/*
 * public�����ֶ�
 */
import java.lang.reflect.Field;

import org.junit.Test;

public class PublicField {
	@Test
	public void fieldMethod() throws Exception   {
		//��ȡʵ������
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//���ֶθ�ֵ
		Field field = clazz.getField("sex");
		field.set(obj, "����");
		
		//��ȡ�ֶ�ֵ
		String sex = (String) field.get(obj);
		
		System.out.println(sex);
	}
}
