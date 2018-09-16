package bull.web01_Servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig servletConfig = this.getServletConfig();
		//获得Servlet在web.xml中配置的name的值.
		String ServletName = servletConfig.getServletName();
		System.out.println(ServletName);//ServletDemo6
		
		//获得web.xml中的Servlet的初始化参数的.
		String username = servletConfig.getInitParameter("username");
		String password = servletConfig.getInitParameter("password");
		System.out.println(username + "---" + password);//root---123
		
		//获得所有Servlet的初始化参数的名称.
		Enumeration<String> en = servletConfig.getInitParameterNames();
		while(en.hasMoreElements()) {
			//获得参数的name值
			String name = en.nextElement();
			//获得参数的value值
			String value = servletConfig.getInitParameter(name);
			System.out.println(name + "---" + value);
			//username---root
			//password---123
		}
  	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
