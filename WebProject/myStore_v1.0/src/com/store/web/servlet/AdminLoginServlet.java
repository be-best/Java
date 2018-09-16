package com.store.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.Adminer;
import com.store.service.UserService;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;

public class AdminLoginServlet extends BaseServlet {

	/**
	 * 管理员登录
	 */
	public String adminLogin(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Adminer adminer = new Adminer();
			adminer.setUsername(username);
			adminer.setPassword(password);
			
			UserService userService = (UserService) BeanFactory.getBean("userService");
			Adminer existAdminer = userService.adminLogin(adminer);
			
			if(existAdminer == null) {
				request.setAttribute("msg", "账号或者密码错误！");
				return "/admin/index.jsp";
			} else {
				//存入session
				request.getSession().setAttribute("existAdminer", existAdminer);
				//重定向
				//response.sendRedirect(request.getContextPath()+"/admin/home.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/home.jsp";
		
	}
	
	/**
	 * 管理员退出
	 */
	public String adminerOut(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}











