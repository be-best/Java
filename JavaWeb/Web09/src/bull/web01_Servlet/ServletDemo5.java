package bull.web01_Servlet;
/**
 * ServletĬ�����ڵ�һ�η��ʵ�ʱ�򴴽���.������Servlet�ڷ�����������ʱ�򴴽���.���ж�Servlet������:
 * ��web.xml����<servlet></servlet>��ǩ������:
 * <load-on-startup>2</load-on-startup>  --- ����������,����ԽС,�����������ȼ���Խ��.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	

	public void init() throws ServletException {
		System.out.println("ServletDemo5��������...");
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
