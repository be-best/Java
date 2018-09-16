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
		//��ǿreq
		ClassLoader loader = req.getClass().getClassLoader();
		Class[] interfaces = req.getClass().getInterfaces();
		//newReq������ǿ���req
		HttpServletRequest newReq = (HttpServletRequest) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
		
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				//�����getParameter����
				if("getParameter".equals(method.getName())) {
					//�ж�������get����post����
					String type = req.getMethod();
					if("get".equalsIgnoreCase(type)) {
						//Get����
						String value = (String) method.invoke(req, args);
						value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
						System.out.println("get");
						return value;
					} else if ("post".equalsIgnoreCase(type)) {
						//Post����
						System.out.println("post");
						req.setCharacterEncoding("UTF-8");
					}
				}
				//�������getParameter��������ֱ�ӷ���method.invoke(req, args)��
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


