package autologin.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import autologin.domain.User;
import autologin.service.UserService;

public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		try {
			//��������
			Map<String,String[]> map = request.getParameterMap();
			User user = new User();
			BeanUtils.populate(user, map);
			UserService userService = new UserService();
			User existUser = userService.userLogin(user);
			
			if(existUser == null) {
				request.setAttribute("error", "�û������������");
				request.getRequestDispatcher("/userLogin/login.jsp").forward(request, response);
			} else {
				//��¼�ɹ�,��ס�û���������
				String autoLogin = request.getParameter("autoLogin");
				if("true".equals(autoLogin)) {
					//��ѡ��ѡ������Ϣ����cookie
					Cookie cookie = new Cookie("autoLogin", existUser.getUsername()+"#"+existUser.getPassword());
					cookie.setPath("/Web15_1");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
					//System.out.println(cookie.getValue());
				} 
				
				//��session��ȡ�û���Ϣ
				request.getSession().setAttribute("existUser", existUser);
				//�ض���
				response.sendRedirect("/Web15_1/userLogin/index.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
