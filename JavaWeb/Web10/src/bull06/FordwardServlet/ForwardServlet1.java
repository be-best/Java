package bull06.FordwardServlet;
/**
 * 1.重定向的地址栏会发生变化,转发的地址栏不变.
 * 2.重定向两次请求两次响应,转发一次请求一次响应.
 * 3.重定向路径需要加工程名,转发的路径不需要加工程名.
 * 4.重定向可以跳转到任意网站,转发只能在服务器内部进行转发.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//重定向
		//response.sendRedirect("/Web10/ForwardServlet2");
		
		//转发
		request.getRequestDispatcher("/ForwardServlet2").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
