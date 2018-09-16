package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyDemo1 {
	@Test
	public void demo1() {
		/**
		 * ClassLoader :类加载器.
		 * Class[]     :被增强的对象实现的所有接口
		 * InvocationHandler	:处理类.
		 */
		Waiter waiter1 = new Waitess();
		//第一个参数:类加载器
		ClassLoader loader = waiter1.getClass().getClassLoader();
		//第二个参数:被增强的对象waiter1实现的所有接口
		Class[] interfaces = waiter1.getClass().getInterfaces();
		
		Waiter waiter = (Waiter) Proxy.newProxyInstance(loader, interfaces, new MyInvocationHandler(waiter1));
		
		 waiter.server();
		String s = waiter.sayHello("张三");
		System.out.println(s);
	}
}


//代理类：
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