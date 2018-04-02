package bull05.Field;
/*
 * public公共字段
 */
import java.lang.reflect.Field;

import org.junit.Test;

public class PublicField {
	@Test
	public void fieldMethod() throws Exception   {
		//获取实例对象
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//给字段赋值
		Field field = clazz.getField("sex");
		field.set(obj, "男性");
		
		//获取字段值
		String sex = (String) field.get(obj);
		
		System.out.println(sex);
	}
}
