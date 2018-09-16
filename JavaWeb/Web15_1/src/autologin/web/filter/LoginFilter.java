package autologin.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import autologin.domain.User;
import autologin.service.UserService;
import autologin.utils.CookieUtils;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * ���ж�session���Ƿ����û�����Ϣ:
		 *�������Ҫ�����session���ܵ�½���еĻ�ֱ�ӵ�½��û�еĻ���cookie���ң�Ȼ�����session���ٵ�½��
		 * * session�������:����.
		 * * session��û��:
		 *    * ��Cookie�л�ȡ:
		 *        * Cookie��û��:����.
		 *        * Cookie����:
		 *            * ��ȡCookie�д���û��������뵽���ݿ��ѯ.
		 *                * û�в�ѯ��:����.
		 *                * ��ѯ��:���û���Ϣ���뵽session . ����.
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		//��session�л�ȡuser
		User user = (User) session.getAttribute("existUser");
		if(user != null) { //session����user
			//����
			chain.doFilter(request, response);
		} else {
			//session��û���û���Ϣ��cookie�л�ȡ
			Cookie[] cookie = req.getCookies();
			//��cookie�в�������ΪautoLogin��cookie
			Cookie autoCookie = CookieUtils.find(cookie, "autoLogin");
			if(autoCookie == null) {
				//����
				chain.doFilter(request, response);
			} else {
				try {
					//�ҵ�������ΪautoLogin��cookie
					String value = autoCookie.getValue();
					//��"username#password"�ָ���
					String[] userMessage = value.split("#");
					User newUser = new User();
					newUser.setUsername(userMessage[0]);
					newUser.setPassword(userMessage[1]);
					
					UserService userService = new UserService();
					User checkUser = userService.userLogin(newUser);
					
					if(checkUser == null) {
						//�û������������cookie���۸�
						chain.doFilter(request, response);
					} else {
						//���û��浽session�У�����
						session.setAttribute("existUser", checkUser);
						chain.doFilter(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
