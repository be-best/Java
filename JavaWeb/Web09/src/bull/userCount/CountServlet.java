package bull.userCount;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ҳ���������������
		response.setContentType("text/html;charset=UTF-8");
		//��ȡcountֵ��ԭ����object����Ҫǿת��
		int count = (int) this.getServletContext().getAttribute("count");
		response.getWriter().print("<font size='5' style='font-weight:bold;'>Welcome���˴��Ǳ���վ�ĵ�<span style='color:red'>"+count+"</span>���û���¼��</font>");
		//response.getWriter().println("<font size='5' style='font-weight:bold;'>��¼�ɹ�!��ӭ��λ׳ʿ:<span style='color:blue'>"+existUser.getNickname()+"</span></font>");

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
