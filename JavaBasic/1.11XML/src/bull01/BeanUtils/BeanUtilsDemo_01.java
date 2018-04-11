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
		 * ��Ҫ������BeanUtils��:
		 * 		commons-beanutils-1.8.3.jar
		 * 		commons-logging-1.1.1.jar
		 */
		//��JavaBeanָ�����Է�װ���ݣ��൱�ڵ���setter����
		BeanUtils.setProperty(users,"userId","ID002");
		BeanUtils.setProperty(users,"userName", "kobe");
		BeanUtils.setProperty(users, "userPasswd", "123");
		
		System.out.println(users);
		//��ȡ����
		String userName = BeanUtils.getProperty(users, "userName");
		System.out.println(userName);
	}
}
