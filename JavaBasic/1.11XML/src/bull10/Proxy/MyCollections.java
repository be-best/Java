package bull10.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class MyCollections {

	@SuppressWarnings({"unchecked","rawtypes"})
	public static List<String> unmodifiableList(final List<String> list) {
		//（目标类）list 所有功能都有
		//（代理类）proxyList 希望不能进行增删改，只能查询,这里实现proxyList比List少了add功能。
		
		//参数一：ClassLoader，动态代理需要一个类加载器
		ClassLoader loader = MyCollections.class.getClassLoader();
		//参数二：Class[] interfaces,需要与目标类接口保持一致
		Class[] interfaces = list.getClass().getInterfaces();
		
		
		List<String> proxyList = (List<String>) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//代理类的方法每被调用一次，处理类invoke方法都执行一次。
				//处理（增强）--不允许添加
				//1.获得方法名
				String methodName = method.getName();
				//2.方法是add时抛异常
				if(methodName.equals("add")) {
					throw new UnsupportedOperationException("不允许进行添加操作！");
				}
				
				//处理类中直接执行目标类中对应的方法
				return method.invoke(list, args);
			}
		});
		
		//返回代理类
		return proxyList;
	}

}
