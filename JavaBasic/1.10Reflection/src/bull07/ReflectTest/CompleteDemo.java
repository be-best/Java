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
 * ��������
 * ��PropertiesDemo_02��BeanConfigUse����
 */
public class CompleteDemo {
	
	//ע������Ͳ���д@Test�ˣ������������setBean()����á�
	public BeanConfig getBean() throws Exception, FileNotFoundException, IOException {
		/*
		 * ��������
		 */
		//����BeanConfig����
		BeanConfig beanConfig = new BeanConfig();
		//��ȡbean.properties�ļ�
		//����Properties����
		Properties beanProp = new Properties();
		//��������ʽ��ȡbean.properties�ļ�
		beanProp.load(new InputStreamReader(new FileInputStream("bean.properties"),"UTF-8"));
		beanConfig.setId(beanProp.getProperty("id"));
		beanConfig.setClassName(beanProp.getProperty("className"));
		
		//��ȡdata.peoperties�ļ�
		//����Properties����
		Properties dataProp = new Properties();
		dataProp.load(new InputStreamReader(new FileInputStream("data.properties"),"UTF-8"));
		//forѭ���Ȼ�ȡdataProp�����key����
		for (String key : dataProp.stringPropertyNames()) {
			//��ȡkey��Ӧ������ֵvalue
			String value = dataProp.getProperty(key);
			//beanConfig.getProp()�൱��һ����������Ϊ��Ӧ�����Ը�ֵ��
			beanConfig.getProp().setProperty(key, value);
		}
		return beanConfig;
		
	}
	
	@Test
	public void setBean() throws FileNotFoundException, IOException, Exception {
		/*
		 * ʹ�����ݴ���JavaBeanʵ������δJavaBean��װ��������
		 */
		BeanConfig beanConfig = getBean();
		//����ʵ��,ʹ�÷��䡣beanConfig.getClassName()����bull07.domain.User.
		Class clazz = Class.forName(beanConfig.getClassName());
		Object obj = clazz.newInstance();
		
		//beanConfig.getProp()��һ������BeanConfig������newһ��Properties����
		for (String key : beanConfig.getProp().stringPropertyNames()) {
			String value = beanConfig.getProp().getProperty(key);
			//��ȡ����
			String methodName = "set" + key.substring(0,1).toUpperCase() + key.substring(1);
			Method method = clazz.getMethod(methodName, String.class);
			//����Ӧ�����Ը���valueֵ��
			method.invoke(obj, value);
		}
		System.out.println(obj);
	
	}
}
