package bull01.BeanUtils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanUtilsDemo_01 {
	
	@Test
	public void method() {
		User users = new User();
		users.setUserId("ID001");
		users.setUserName("jack");
		users.setUserPasswd("123456");
		
		System.out.println(users);
	}
	
	@Test
	public void method2() throws Exception, InvocationTargetException {
		User users = new User();
		
		/*
		 * 需要导两个BeanUtils包:
		 * 		commons-beanutils-1.8.3.jar
		 * 		commons-logging-1.1.1.jar
		 */
		//给JavaBean指定属性封装数据，相当于调用setter方法
		BeanUtils.setProperty(users,"userId","ID002");
		BeanUtils.setProperty(users,"userName", "kobe");
		BeanUtils.setProperty(users, "userPasswd", "123");
		
		System.out.println(users);
		//获取数据
		String userName = BeanUtils.getProperty(users, "userName");
		System.out.println(userName);
	}
}
