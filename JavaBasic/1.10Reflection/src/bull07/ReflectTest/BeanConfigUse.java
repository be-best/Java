package bull07.ReflectTest;

import java.lang.reflect.Method;

import org.junit.Test;

import bull07.domain.BeanConfig;

/*
 * 使用BeanConfig数据
 */
public class BeanConfigUse {
	@Test
	public void method() throws Exception {
		//创建BeanConfig对象
		BeanConfig beanConfig = new BeanConfig();
		//配置beanConfig数据
		beanConfig.setId("mo001");
		beanConfig.setClassName("bull07.domain.User");
		//配置User数据
		beanConfig.getProp().setProperty("userName", "moni002");
		beanConfig.getProp().setProperty("userPasswd", "moniPasswd2");
		beanConfig.getProp().setProperty("userId", "moniId2");
		
		//使用数据创建JavaBean实例，并未JavaBean封装具体事例
		//创建实例，使用反射.beanConfig.getClassName()就是bull07.domain.User.
		Class clazz = Class.forName(beanConfig.getClassName());
		Object obj = clazz.newInstance();
		
		//beanConfig.getProp().stringPropertyNames()先获取所有的key集合
		for (String key : beanConfig.getProp().stringPropertyNames()) {
			//获取value
			String value = beanConfig.getProp().getProperty(key);
			//获取方法.substring(0,1)意思是获取第0个字符，substring(1)意思是获取第1以及以后的字符。
			String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);//方法名
			Method method = clazz.getMethod(methodName, String.class);//获取了方法
			//给属性赋上value值
			method.invoke(obj, value);
		}
		System.out.println(obj);
		

	}
	
}
