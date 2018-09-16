package bull02.ServletContext.initparam;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ��ȡȫ�ֳ�ʼ������
		 */
		String username = this.getServletContext().getInitParameter("username");
		String password = this.getServletContext().getInitParameter("password");
		System.out.println(username + "---" + password);//root---123
		
		Enumeration<String> en = this.getServletContext().getInitParameterNames();
		while(en.hasMoreElements()) {
			//��ȡ����name
			String name = en.nextElement();
			//��ȡ����value
			String value = this.getServletContext().getInitParameter(name);
			System.out.println(name + "---" +value);
			//username---root
			//password---123
		}
		
		/**
		 * ����ļ���MIME������
		 */
		String type = this.getServletContext().getMimeType("1.jpg");
		System.out.println(type);//image/jpeg
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
