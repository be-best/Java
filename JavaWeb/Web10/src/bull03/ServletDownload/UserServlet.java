package bull03.ServletDownload;

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
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
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
//			System.out.println(existUser.getUsername());
//			System.out.println(existUser.getPassword());
			//��֤����
			if(existUser == null) {
				//response.getWriter().println("<h2>��¼ʧ��,�û������������</h2>");
				//request.setAttribute("msg", "<font style='color:red'>�û��������������</font>");
				request.setAttribute("msg", "<h5 style='color:red'>�û��������������</h5>");
				request.getRequestDispatcher("/userLogin/login.jsp").forward(request, response);
			} else {
				//response.getWriter().println("<font size='6' style='font-weight:bold;'>��½�ɹ�����ӭ����<span style='color:blue'>"+existUser.getNickname()+"</span></font>");
				response.setStatus(302);
				response.setHeader("Location", "/Web10/userLogin/success.html");
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
