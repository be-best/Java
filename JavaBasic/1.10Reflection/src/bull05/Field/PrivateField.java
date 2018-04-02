package bull05.Field;

import java.lang.reflect.Field;

import org.junit.Test;

/*
 * private私有字段
 */
public class PrivateField {
	@Test
	public void privateField() throws Exception {
		//1.获取实例
		Class clazz = Class.forName("bull04.Method.Bean");
		Object obj = clazz.newInstance();
		
		//2.给字段赋值
		Field field = clazz.getDeclaredField("name");
		
		//2.1设置运行访问私有（暴力）
		field.setAccessible(true);
		//2.2先暴力再赋值
		field.set(obj, "张三");
		
		//3.获取字段值
		String name = (String) field.get(obj);
		System.out.println(name);
	}
}
