package com.store.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.store.domain.Adminer;
/**
 * 后台页面的过滤器，只有session中有管理员的账号信息时才能登录后台界面
 * @author 45度炸
 *
 */
public class AdminLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		Adminer adminer = (Adminer) session.getAttribute("existAdminer");
		if(adminer != null) {
			chain.doFilter(request, res);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
