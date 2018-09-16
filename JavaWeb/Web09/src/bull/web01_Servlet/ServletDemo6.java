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
		//���Servlet��web.xml�����õ�name��ֵ.
		String ServletName = servletConfig.getServletName();
		System.out.println(ServletName);//ServletDemo6
		
		//���web.xml�е�Servlet�ĳ�ʼ��������.
		String username = servletConfig.getInitParameter("username");
		String password = servletConfig.getInitParameter("password");
		System.out.println(username + "---" + password);//root---123
		
		//�������Servlet�ĳ�ʼ������������.
		Enumeration<String> en = servletConfig.getInitParameterNames();
		while(en.hasMoreElements()) {
			//��ò�����nameֵ
			String name = en.nextElement();
			//��ò�����valueֵ
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
