package bull05.Request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得请求方式：
		String method = request.getMethod();
		System.out.println("请求方式："+method);//请求方式：GET
		
		// 获得客户机的IP地址：
		String IPaddr = request.getRemoteAddr();
		System.out.println("客户机的IP地址："+IPaddr);//客户机的IP地址：0:0:0:0:0:0:0:1
		
		// 获得用户的请求的路径:
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		System.out.println("获得请求的URL："+url);//获得请求的URL：http://localhost:8080/Web10/RequestServlet
		System.out.println("获得请求的URI"+uri);//获得请求的URI/Web10/RequestServlet
		
		// 获得发布的工程名：
		String contextpath = request.getContextPath();
		System.out.println("发布的工程名："+contextpath);//发布的工程名：/Web10
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
