package bull05.Request;
/**
 * ���Request������������
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
		 * doGet�������
		 */
		String name = new String(request.getParameter("nameget").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("doGet��ʽ��"+name);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * doPost�������
		 */
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("namepost");
		System.out.println("doPost��ʽ��"+name);
	
	}

}
