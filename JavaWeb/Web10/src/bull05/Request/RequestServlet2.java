package bull05.Request;
/**
 * 解决Request中文乱码问题
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * doGet解决方法
		 */
		String name = new String(request.getParameter("nameget").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("doGet方式："+name);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * doPost解决方法
		 */
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("namepost");
		System.out.println("doPost方式："+name);
	
	}

}
