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
 * �û�ģ���Servlet
 * @author 45��ը
 *
 */
public class UserServlet extends BaseServlet {

	/**
	 * registUI:��ת��ע�����
	 */
	public String registUI(HttpServletRequest req,HttpServletResponse res) {
		return "/jsp/regist.jsp";
	}

	/**
	 * checkUsername:�첽У���û���
	 */
	public String checkUsername(HttpServletRequest request, HttpServletResponse response) {
		try {
			//�����ı����û���
			String username = request.getParameter("username");
			UserService userService = (UserService) BeanFactory.getBean("userService");
			//����ҵ��㴦������
			//System.out.println(username+"---1");
			User user = userService.findByUsername(username);
			if(username == null) {
				response.getWriter().print(0);
			}
			else if(user != null  ) {
				//�û�������
				response.getWriter().print(0);
			} else if(user == null) {
				//�û���������
				response.getWriter().print(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//ҳ�治��ת�������Է���һ��null
		return null;
	}
	
	/**
	 * regist:�û�ע��
	 */
	public String regist(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
			Map<String,String[]> map = request.getParameterMap();
			User newUser = new User();
			//�޸����ڸ�ʽ
			ConvertUtils.register(new MyDateConverter(), Date.class);
			//��װ���ݣ���map���ݷ�װ��newUser��
			BeanUtils.populate(newUser, map);
			newUser.setState(2);
			UserService userService = (UserService) BeanFactory.getBean("userService");
			userService.saveUser(newUser);
			request.setAttribute("msg", "ע��ɹ�����ӭ�»��Ѽ��������ͥ��");
			return "/jsp/msg.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
	
	/**
	 * active:�û�����
	 
	public String active(HttpServletRequest request, HttpServletResponse response) {
		try {
			//���ղ���
			String code = request.getParameter("code");
			UserService userService = (UserService) BeanFactory.getBean("userService");
			User user = userService.findByCode(code);
			if(user == null) {
				request.setAttribute("msg", "����ʧ��...�����¼��");
			} else {
				//״̬������Ϊ2���Ѽ���
				user.setState(2);
				//����������Ϊ��
				user.setCode(null);
				userService.updateUser(user);
				request.setAttribute("msg", "����ɹ�����ӭ�»��ѣ��п�һ��������");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/msg.jsp";
		
	}
	*/
	
	/**
	 * loginUI:��ת����¼����
	 */
	public String loginUI(HttpServletRequest request,HttpServletResponse response) {
		return "/jsp/login.jsp";
	}
	
	/**
	 * login:��¼����
	 */
	public String login(HttpServletRequest request,HttpServletResponse response) {
		try {
			//��֤��ļ���
			//��ȡ�û��������֤��
			String code1 = request.getParameter("code");
			//��session�л�ȡCheckServlet�����õ���֤��
			String code2 = (String) request.getSession().getAttribute("code");
			System.out.println(code2);
			if(!code1.equalsIgnoreCase(code2)) {
				request.setAttribute("msg", "���������֤�벻��ȷ��");
				return "/jsp/login.jsp";
			}
			//���ղ���
			Map<String,String[]> map = request.getParameterMap();
			User user = new User();
			BeanUtils.populate(user, map);
			UserService userService = (UserService) BeanFactory.getBean("userService");
			User existUser = userService.userLogin(user);
			if(existUser == null) {
				request.setAttribute("msg", "�û��������������");
				return "/jsp/login.jsp";
			} else {
				/*
				//��¼�ɹ�,ʵ���Զ���½
				String autoLogin = request.getParameter("autoLogin");
				if("true".equals(autoLogin)) {
					Cookie cookie = new Cookie("autoLogin",existUser.getUsername()+"#"+existUser.getPassword());
					cookie.setPath("/myStore_v1.0");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				
				//��ס�û���
				String remember = request.getParameter("remember");
				if("true".equals(remember)) {
					Cookie cookie = new Cookie("remember",existUser.getUsername());
					cookie.setPath("/myStore_v1.0");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				*/
				request.getSession().setAttribute("existUser", existUser);
				//�ض�����ת����ҳ
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
	 * �˳�����
	 */
	public String logOut(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//����session
			request.getSession().invalidate();
			//����cookie
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












