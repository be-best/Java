package bull06.FordwardServlet;
/**
 * 1.�ض���ĵ�ַ���ᷢ���仯,ת���ĵ�ַ������.
 * 2.�ض�����������������Ӧ,ת��һ������һ����Ӧ.
 * 3.�ض���·����Ҫ�ӹ�����,ת����·������Ҫ�ӹ�����.
 * 4.�ض��������ת��������վ,ת��ֻ���ڷ������ڲ�����ת��.
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
		//�ض���
		//response.sendRedirect("/Web10/ForwardServlet2");
		
		//ת��
		request.getRequestDispatcher("/ForwardServlet2").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
