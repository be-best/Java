package bull07.ReflectTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

import bull07.domain.BeanConfig;

/*
 * 案例整合
 * 将PropertiesDemo_02和BeanConfigUse整合
 */
public class CompleteDemo {
	
	//注意这里就不用写@Test了，这个方法下面setBean()会调用。
	public BeanConfig getBean() throws Exception, FileNotFoundException, IOException {
		/*
		 * 配置数据
		 */
		//创建BeanConfig对象
		BeanConfig beanConfig = new BeanConfig();
		//读取bean.properties文件
		//创建Properties对象
		Properties beanProp = new Properties();
		//采用流方式读取bean.properties文件
		beanProp.load(new InputStreamReader(new FileInputStream("bean.properties"),"UTF-8"));
		beanConfig.setId(beanProp.getProperty("id"));
		beanConfig.setClassName(beanProp.getProperty("className"));
		
		//读取data.peoperties文件
		//创建Properties对象
		Properties dataProp = new Properties();
		dataProp.load(new InputStreamReader(new FileInputStream("data.properties"),"UTF-8"));
		//for循环先获取dataProp对象的key集合
		for (String key : dataProp.stringPropertyNames()) {
			//获取key对应的属性值value
			String value = dataProp.getProperty(key);
			//beanConfig.getProp()相当于一个对象。这里为对应的属性赋值。
			beanConfig.getProp().setProperty(key, value);
		}
		return beanConfig;
		
	}
	
	@Test
	public void setBean() throws FileNotFoundException, IOException, Exception {
		/*
		 * 使用数据创建JavaBean实例，并未JavaBean封装具体事例
		 */
		BeanConfig beanConfig = getBean();
		//创建实例,使用反射。beanConfig.getClassName()就是bull07.domain.User.
		Class clazz = Class.forName(beanConfig.getClassName());
		Object obj = clazz.newInstance();
		
		//beanConfig.getProp()是一个对象，BeanConfig里面有new一个Properties对象。
		for (String key : beanConfig.getProp().stringPropertyNames()) {
			String value = beanConfig.getProp().getProperty(key);
			//获取方法
			String methodName = "set" + key.substring(0,1).toUpperCase() + key.substring(1);
			Method method = clazz.getMethod(methodName, String.class);
			//给对应的属性赋上value值。
			method.invoke(obj, value);
		}
		System.out.println(obj);
	
	}
}
