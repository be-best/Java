package bull.web01_Servlet;
/**
 * 用户第一次访问Servlet的时候,服务器会创建一个Servlet的实例,那么Servlet中init方法就会执行.
 *   任何一次请求服务器都会创建一个新的线程访问Servlet中的service的方法.
 *   在service方法内部根据请求的方式的不同调用doXXX的方法.(get请求调用doGet,post请求调用doPost).
 *   当Servlet中服务器中移除掉,或者关闭服务器,Servlet的实例就会被销毁,那么destroy方法就会执行.
 */
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo4 implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletDemo4被创建了...");
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("ServletDemo4的Service被调用了...");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("ServletDemo4的Servlet被销毁了...");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}


}
