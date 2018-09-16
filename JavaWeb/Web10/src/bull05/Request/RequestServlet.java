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
		// �������ʽ��
		String method = request.getMethod();
		System.out.println("����ʽ��"+method);//����ʽ��GET
		
		// ��ÿͻ�����IP��ַ��
		String IPaddr = request.getRemoteAddr();
		System.out.println("�ͻ�����IP��ַ��"+IPaddr);//�ͻ�����IP��ַ��0:0:0:0:0:0:0:1
		
		// ����û��������·��:
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		System.out.println("��������URL��"+url);//��������URL��http://localhost:8080/Web10/RequestServlet
		System.out.println("��������URI"+uri);//��������URI/Web10/RequestServlet
		
		// ��÷����Ĺ�������
		String contextpath = request.getContextPath();
		System.out.println("�����Ĺ�������"+contextpath);//�����Ĺ�������/Web10
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
