package bull07.ReflectTest;

import java.lang.reflect.Method;

import org.junit.Test;

import bull07.domain.BeanConfig;

/*
 * ʹ��BeanConfig����
 */
public class BeanConfigUse {
	@Test
	public void method() throws Exception {
		//����BeanConfig����
		BeanConfig beanConfig = new BeanConfig();
		//����beanConfig����
		beanConfig.setId("mo001");
		beanConfig.setClassName("bull07.domain.User");
		//����User����
		beanConfig.getProp().setProperty("userName", "moni002");
		beanConfig.getProp().setProperty("userPasswd", "moniPasswd2");
		beanConfig.getProp().setProperty("userId", "moniId2");
		
		//ʹ�����ݴ���JavaBeanʵ������δJavaBean��װ��������
		//����ʵ����ʹ�÷���.beanConfig.getClassName()����bull07.domain.User.
		Class clazz = Class.forName(beanConfig.getClassName());
		Object obj = clazz.newInstance();
		
		//beanConfig.getProp().stringPropertyNames()�Ȼ�ȡ���е�key����
		for (String key : beanConfig.getProp().stringPropertyNames()) {
			//��ȡvalue
			String value = beanConfig.getProp().getProperty(key);
			//��ȡ����.substring(0,1)��˼�ǻ�ȡ��0���ַ���substring(1)��˼�ǻ�ȡ��1�Լ��Ժ���ַ���
			String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);//������
			Method method = clazz.getMethod(methodName, String.class);//��ȡ�˷���
			//�����Ը���valueֵ
			method.invoke(obj, value);
		}
		System.out.println(obj);
		

	}
	
}
