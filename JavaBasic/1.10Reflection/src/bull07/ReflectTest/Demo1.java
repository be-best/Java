package bull07.ReflectTest;

import org.junit.Test;

import bull07.domain.BeanConfig;

public class Demo1 {
	@Test
	public void method() {
		//模拟数据
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setId("moni001");
		beanConfig.setClassName("bull07.domain.User");
		
		//beanConfih.getProp()其实就是获取了Properties对象，因为BeanConfig里有创建Properties对象。
		beanConfig.getProp().setProperty("userName", "moniName");
		beanConfig.getProp().setProperty("userPasswd", "moniPasswd");
		beanConfig.getProp().setProperty("userId", "moniId");
		
		System.out.println(beanConfig);
	}
}
