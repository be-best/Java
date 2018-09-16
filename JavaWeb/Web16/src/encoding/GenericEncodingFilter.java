package encoding;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class GenericEncodingFilter implements Filter {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;
		//增强req
		ClassLoader loader = req.getClass().getClassLoader();
		Class[] interfaces = req.getClass().getInterfaces();
		//newReq就是增强完的req
		HttpServletRequest newReq = (HttpServletRequest) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
		
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				//如果是getParameter方法
				if("getParameter".equals(method.getName())) {
					//判断请求是get还是post方法
					String type = req.getMethod();
					if("get".equalsIgnoreCase(type)) {
						//Get请求
						String value = (String) method.invoke(req, args);
						value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
						System.out.println("get");
						return value;
					} else if ("post".equalsIgnoreCase(type)) {
						//Post请求
						System.out.println("post");
						req.setCharacterEncoding("UTF-8");
					}
				}
				//如果不是getParameter方法，则直接返回method.invoke(req, args)；
				return method.invoke(req, args);
			}
		});
		 
		chain.doFilter(newReq, response);
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}


