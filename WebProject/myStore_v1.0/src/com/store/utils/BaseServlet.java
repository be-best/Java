package com.store.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承HttpServlet实现一个通用的Servlet
 * @author 45度炸
 *
 */
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/myStore_v1.0/UserServlet?method=regist
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//接收参数获得方法名称
		String methodName = request.getParameter("method");
		if(methodName == null) {
			response.getWriter().print("Can not find the method!Please check if you have the method!");
			return;
		}
		//获得子类class对象,子类继承BaseServlet时this.getClass()就是获取子类class对象
		Class clazz = this.getClass();
		try {
			//获得子类中的方法
			Method method = clazz.getMethod(methodName, HttpServletRequest.class ,HttpServletResponse.class);
			//执行该方法,返回该方法界面的路径
			String path = (String) method.invoke(this, request ,response);
			if(path != null) {
				//转发到对应的方法界面
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
