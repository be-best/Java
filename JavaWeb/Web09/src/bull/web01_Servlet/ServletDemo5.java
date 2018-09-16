package bull.web01_Servlet;
/**
 * Servlet默认是在第一次访问的时候创建的.现在让Servlet在服务器启动的时候创建好.进行对Servlet的配置:
 * 在web.xml中在<servlet></servlet>标签中配置:
 * <load-on-startup>2</load-on-startup>  --- 传入正整数,整数越小,被创建的优先级就越高.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	

	public void init() throws ServletException {
		System.out.println("ServletDemo5被创建了...");
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
