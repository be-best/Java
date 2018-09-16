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
		 * 先判断session中是否有用户的信息:
		 *（服务端要有这个session才能登陆，有的话直接登陆，没有的话从cookie中找，然后存入session中再登陆）
		 * * session中如果有:放行.
		 * * session中没有:
		 *    * 从Cookie中获取:
		 *        * Cookie中没有:放行.
		 *        * Cookie中有:
		 *            * 获取Cookie中存的用户名和密码到数据库查询.
		 *                * 没有查询到:放行.
		 *                * 查询到:将用户信息存入到session . 放行.
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		//从session中获取user
		User user = (User) session.getAttribute("existUser");
		if(user != null) { //session中有user
			//放行
			chain.doFilter(request, response);
		} else {
			//session中没有用户信息从cookie中获取
			Cookie[] cookie = req.getCookies();
			//从cookie中查找名称为autoLogin的cookie
			Cookie autoCookie = CookieUtils.find(cookie, "autoLogin");
			if(autoCookie == null) {
				//放行
				chain.doFilter(request, response);
			} else {
				try {
					//找到了名称为autoLogin的cookie
					String value = autoCookie.getValue();
					//将"username#password"分隔开
					String[] userMessage = value.split("#");
					User newUser = new User();
					newUser.setUsername(userMessage[0]);
					newUser.setPassword(userMessage[1]);
					
					UserService userService = new UserService();
					User checkUser = userService.userLogin(newUser);
					
					if(checkUser == null) {
						//用户名或密码错误；cookie被篡改
						chain.doFilter(request, response);
					} else {
						//将用户存到session中，放行
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
