package bull07.ReflectTest;

import org.junit.Test;

import bull07.domain.BeanConfig;

public class Demo1 {
	@Test
	public void method() {
		//ģ������
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setId("moni001");
		beanConfig.setClassName("bull07.domain.User");
		
		//beanConfih.getProp()��ʵ���ǻ�ȡ��Properties������ΪBeanConfig���д���Properties����
		beanConfig.getProp().setProperty("userName", "moniName");
		beanConfig.getProp().setProperty("userPasswd", "moniPasswd");
		beanConfig.getProp().setProperty("userId", "moniId");
		
		System.out.println(beanConfig);
	}
}
