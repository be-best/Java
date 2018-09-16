package com.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.store.domain.User;
import com.store.service.UserService;
import com.store.service.imple.UserServiceImple;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;
import com.store.utils.MyDateConverter;
/**
 * 用户模块的Servlet
 * @author 45度炸
 *
 */
public class UserServlet extends BaseServlet {

	/**
	 * registUI:跳转到注册界面
	 */
	public String registUI(HttpServletRequest req,HttpServletResponse res) {
		return "/jsp/regist.jsp";
	}

	/**
	 * checkUsername:异步校验用户名
	 */
	public String checkUsername(HttpServletRequest request, HttpServletResponse response) {
		try {
			//接收文本框用户名
			String username = request.getParameter("username");
			UserService userService = (UserService) BeanFactory.getBean("userService");
			//调用业务层处理数据
			//System.out.println(username+"---1");
			User user = userService.findByUsername(username);
			if(username == null) {
				response.getWriter().print(0);
			}
			else if(user != null  ) {
				//用户名存在
				response.getWriter().print(0);
			} else if(user == null) {
				//用户名不存在
				response.getWriter().print(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//页面不用转发，所以返回一个null
		return null;
	}
	
	/**
	 * regist:用户注册
	 */
	public String regist(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			Map<String,String[]> map = request.getParameterMap();
			User newUser = new User();
			//修改日期格式
			ConvertUtils.register(new MyDateConverter(), Date.class);
			//封装数据，把map数据封装到newUser中
			BeanUtils.populate(newUser, map);
			newUser.setState(2);
			UserService userService = (UserService) BeanFactory.getBean("userService");
			userService.saveUser(newUser);
			request.setAttribute("msg", "注册成功！欢迎新机友加入搞机大家庭！");
			return "/jsp/msg.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
	
	/**
	 * active:用户激活
	 
	public String active(HttpServletRequest request, HttpServletResponse response) {
		try {
			//接收参数
			String code = request.getParameter("code");
			UserService userService = (UserService) BeanFactory.getBean("userService");
			User user = userService.findByCode(code);
			if(user == null) {
				request.setAttribute("msg", "激活失败...请重新激活！");
			} else {
				//状态码设置为2，已激活
				user.setState(2);
				//激活码设置为空
				user.setCode(null);
				userService.updateUser(user);
				request.setAttribute("msg", "激活成功！欢迎新机友，有空一起搞机啊！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/msg.jsp";
		
	}
	*/
	
	/**
	 * loginUI:跳转到登录界面
	 */
	public String loginUI(HttpServletRequest request,HttpServletResponse response) {
		return "/jsp/login.jsp";
	}
	
	/**
	 * login:登录功能
	 */
	public String login(HttpServletRequest request,HttpServletResponse response) {
		try {
			//验证码的检验
			//获取用户输入的验证码
			String code1 = request.getParameter("code");
			//从session中获取CheckServlet中设置的验证码
			String code2 = (String) request.getSession().getAttribute("code");
			System.out.println(code2);
			if(!code1.equalsIgnoreCase(code2)) {
				request.setAttribute("msg", "您输入的验证码不正确！");
				return "/jsp/login.jsp";
			}
			//接收参数
			Map<String,String[]> map = request.getParameterMap();
			User user = new User();
			BeanUtils.populate(user, map);
			UserService userService = (UserService) BeanFactory.getBean("userService");
			User existUser = userService.userLogin(user);
			if(existUser == null) {
				request.setAttribute("msg", "用户名或者密码错误");
				return "/jsp/login.jsp";
			} else {
				/*
				//登录成功,实现自动登陆
				String autoLogin = request.getParameter("autoLogin");
				if("true".equals(autoLogin)) {
					Cookie cookie = new Cookie("autoLogin",existUser.getUsername()+"#"+existUser.getPassword());
					cookie.setPath("/myStore_v1.0");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				
				//记住用户名
				String remember = request.getParameter("remember");
				if("true".equals(remember)) {
					Cookie cookie = new Cookie("remember",existUser.getUsername());
					cookie.setPath("/myStore_v1.0");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				*/
				request.getSession().setAttribute("existUser", existUser);
				//重定向跳转到首页
				response.sendRedirect(request. getContextPath()+"/index.jsp");
				return null; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * 退出功能
	 */
	public String logOut(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//销毁session
			request.getSession().invalidate();
			//销毁cookie
			Cookie cookie = new Cookie("autoLogin",null);
			cookie.setPath("/myStore_v1.0");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}












