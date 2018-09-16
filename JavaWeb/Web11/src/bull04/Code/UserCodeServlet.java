package bull04.Code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull01.VisitTime.User;
import bull01.VisitTime.UserService;

public class UserCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//��ȡ�ύ�ı��е�code
			String code1 = request.getParameter("code");
			//��ȡSession�е�code
			String code2 = (String) request.getSession().getAttribute("code");
			//���Session�е�code
			request.getSession().removeAttribute("code");
			
			if(!code1.equals(code2)) {
				request.setAttribute("err", "<font style='color:red'>��֤�����벻��ȷ</font>");
				request.getRequestDispatcher("/code/login.jsp").forward(request, response);
				return ;
			}
			
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
				
				//����״̬��
				response.setStatus(302);
				//Locationֱ����ת
				response.setHeader("Location", "/Web11/code/success.html");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
