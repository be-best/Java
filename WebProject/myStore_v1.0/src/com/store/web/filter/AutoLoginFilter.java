package com.store.web.filter;

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

import com.store.domain.User;
import com.store.service.UserService;
import com.store.service.imple.UserServiceImple;
import com.store.utils.CookieUtils;



/**
 * �Զ���¼�Ĺ�������ʵ��
 * @author admin
 *
 */
public class AutoLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * �ж�session���Ƿ����û�����Ϣ:
		 * * session�������:����.
		 * * session��û��:
		 *    * ��Cookie�л�ȡ:
		 *        * Cookie��û��:����.
		 *        * Cookie����:
		 *            * ��ȡCookie�д���û��������뵽���ݿ��ѯ.
		 *                * û�в�ѯ��:����.
		 *                * ��ѯ��:���û���Ϣ���뵽session . ����.
		 */
		// �ж�session���Ƿ����û�����Ϣ:
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User existUser = (User) session.getAttribute("existUser");
		if(existUser != null){
			// session�����û���Ϣ.
			chain.doFilter(req, response);
		}else{
			// session��û���û���Ϣ.
			// ���Cookie������:
			Cookie[] cookies = req.getCookies();
			Cookie cookie = CookieUtils.findCookie(cookies, "autoLogin");
			// �ж�Cookie����û����Ϣ:
			if(cookie == null){
				// û��Я��Cookie����Ϣ����:
				chain.doFilter(req, response);
			}else{
				// ����Cookie��Ϣ����.
				String value = cookie.getValue();// aaa#111
				// ����û���������:
				String username = value.split("#")[0];
				String password = value.split("#")[1];
				// ȥ���ݿ���в�ѯ:
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				UserService userService = new UserServiceImple();
				try {
					existUser = userService.userLogin(user);
					if(existUser == null){
						// �û������������:Cookie���۸ĵ�.
						chain.doFilter(req, response);
					}else{
						// ���û��浽session��,����
						session.setAttribute("existUser", existUser);
						chain.doFilter(req, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void destroy() {
		
	}

}
