package bull.userLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//��������
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//��װ����
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

			//ҵ��㴦������
			UserService userService = new UserService();
			User existUser = userService.login(user);
			//��֤����
			if(existUser == null) {
				response.getWriter().println("fail");
			} else {
				response.getWriter().println("success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * һ�����������ʱ�����ȵ��õ���service����
	 * Ȼ��������form����post�����doPost����������get�����doGet���������������д��Ĭ��ΪdoGet����
	 * ���ԣ�һ������£�doGet������doPost��������һ��Ҫ��ִ�е�
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//form��ʱpost,��������Ҫ����doget,��Ϊ������д��doget�Ǳ�
		doGet(request, response);
	}

}
