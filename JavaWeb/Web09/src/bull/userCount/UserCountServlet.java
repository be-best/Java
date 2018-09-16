package bull.userCount;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull.userLogin.User;
import bull.userLogin.UserService;

public class UserCountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Servlet����ʱ�ͳ�ʼ��һ��countֵ
	 */
	public void init() throws ServletException {
		//��ʼ��һ��countֵ
		int count = 0;
		//��countֵ����ServletCount
		this.getServletContext().setAttribute("count", count);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//�����ҳ���������������
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
			//��֤����
			if(existUser == null) {
				response.getWriter().println("<h2>�Բ�ס����λ׳ʿ���˴ε�¼ʧ��...</h2>");
			} else {
				response.getWriter().println("<font size='5' style='font-weight:bold;'>��¼�ɹ�!��ӭ��λ׳ʿ:<span style='color:blue'>"+existUser.getNickname()+"</span></font>");
				response.getWriter().println("<h3>ҳ�潫��5�����ת...</h3>");
				//Refresh��ʱ��ת
				response.setHeader("Refresh", "5;url=/Web01/CountServlet");
				//����״̬��
				//response.setStatus(302);
				//Locationֱ����ת
				//response.setHeader("Location", "/Web01/userRefresh/success.html");
				
				//��¼�ɹ���ȡcountֵ����1������һ�ε�¼�˴Ρ�
				int count = (int) this.getServletContext().getAttribute("count");//object����Ҫǿת
				count++;
				this.getServletContext().setAttribute("count", count);
				
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
