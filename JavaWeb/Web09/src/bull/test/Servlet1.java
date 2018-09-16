package bull.test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Servlet鐨勭敓鍛藉懆鏈�
 * @author jt
 *
 */
public class Servlet1 implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet1创建...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet1的Service调用..");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet1销毁...");
	}

	
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


}
