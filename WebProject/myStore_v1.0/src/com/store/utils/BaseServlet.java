package com.store.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �̳�HttpServletʵ��һ��ͨ�õ�Servlet
 * @author 45��ը
 *
 */
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/myStore_v1.0/UserServlet?method=regist
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//���ղ�����÷�������
		String methodName = request.getParameter("method");
		if(methodName == null) {
			response.getWriter().print("Can not find the method!Please check if you have the method!");
			return;
		}
		//�������class����,����̳�BaseServletʱthis.getClass()���ǻ�ȡ����class����
		Class clazz = this.getClass();
		try {
			//��������еķ���
			Method method = clazz.getMethod(methodName, HttpServletRequest.class ,HttpServletResponse.class);
			//ִ�и÷���,���ظ÷��������·��
			String path = (String) method.invoke(this, request ,response);
			if(path != null) {
				//ת������Ӧ�ķ�������
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
