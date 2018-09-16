package bull04.out;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutPrintServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		test1(response);
//		test2(response);
		//test3(response);
		test4(response);
	}

	/**
	 * �ַ���:
     * ����������򿪵�ʱ��ı���
     * resposne.setHeader(��Content-Type��,��text/html;charset=UTF-8��);
     * ����response�Ļ������ı���
     * response.setCharacterEncoding(��UTF-8��);
	 * @param response
	 * @throws IOException 
	 */
	private void test4(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("�ַ���");
	}

	/**
	 * �ֽ���:
     * ���������Ĭ�ϴ򿪵ı���:
     * resposne.setHeader(��Content-Type��,��text/html;charset=UTF-8��);
     * ���������ֽ�ȡ����ʱ�����.
     * �����ġ�.getBytes(��UTF-8��);
	 * @param response
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	private void test3(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		//���������Ĭ�ϴ򿪵ı���:
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		//���������ֽ�ȡ����ʱ�����.
		response.getOutputStream().write("�ֽ���".getBytes("UTF-8"));
	}


	private void test2(HttpServletResponse response) throws IOException {
		response.getWriter().print("Hello Response...");
		
	}


	private void test1(HttpServletResponse response) throws IOException {
		response.getOutputStream().write("Hello OutputStream Response...".getBytes());
	}
	
	


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
