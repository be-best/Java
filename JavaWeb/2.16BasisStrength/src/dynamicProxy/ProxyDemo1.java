package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyDemo1 {
	@Test
	public void demo1() {
		/**
		 * ClassLoader :�������.
		 * Class[]     :����ǿ�Ķ���ʵ�ֵ����нӿ�
		 * InvocationHandler	:������.
		 */
		Waiter waiter1 = new Waitess();
		//��һ������:�������
		ClassLoader loader = waiter1.getClass().getClassLoader();
		//�ڶ�������:����ǿ�Ķ���waiter1ʵ�ֵ����нӿ�
		Class[] interfaces = waiter1.getClass().getInterfaces();
		
		Waiter waiter = (Waiter) Proxy.newProxyInstance(loader, interfaces, new MyInvocationHandler(waiter1));
		
		 waiter.server();
		String s = waiter.sayHello("����");
		System.out.println(s);
	}
}


//�����ࣺ
class MyInvocationHandler implements InvocationHandler {

	private Waiter waiter;

	public MyInvocationHandler(Waiter waiter) {
		this.waiter = waiter;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if("server".equals(method.getName())) {
			System.out.println("This is server:");
			Object obj = method.invoke(waiter, args);
			return obj;
		} else {
			System.out.println("This is sayHello:");
			Object obj = method.invoke(waiter, args);
			 return obj;
		}
		
	}
	
}