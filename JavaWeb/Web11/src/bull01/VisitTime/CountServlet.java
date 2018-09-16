package bull01.VisitTime;
/*
 * ���������д����������е�Cookie��Ϣ,�������в�����û��ָ�����Ƶ�Cookie
 * �ж��û��Ƿ��ǵ�һ�η���:(��������û���ҵ�ָ�����Ƶ�Cookie)
 * * ����ǵ�һ��:��ʾ��ӭ,��¼��ǰ���ʵ�ʱ����뵽Cookie��.
 * * ������ǵ�һ��:��ʾ��ӭ,��һ�η���ʱ��,ͬʱ��¼��ǰ���ʵ�ʱ����뵽Cookie�С�
 */
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull.Utils.CookieUtils;

public class CountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ҳ���������������
		response.setContentType("text/html;charset=UTF-8");
		//��ȡcountֵ��ԭ����object����Ҫǿת��
		int count = (int) this.getServletContext().getAttribute("count");
		
		//��������������������cookies
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtils.find(cookies, "lastVisit");
		//�ж��Ƿ��ǵ�һ��
		if(cookie == null) {
			response.getWriter().print("<font size='3' style='font-weight:bold;'>Welcome���˴��Ǳ���վ�ĵ�<span style='color:red'>"+count+"</span>���û���¼��</font>");
		} else {
			//���ǵ�һ��
			Long l = Long.parseLong(cookie.getValue());
			Date date = new Date(l);
			response.getWriter().print("<font size='3' style='font-weight:bold;'>Welcome���˴��Ǳ���վ�ĵ�<span style='color:red'>"+count+"</span>���û���¼��       �ϴε�¼ʱ���ǣ�"+date.toLocaleString()+"</font>");
		}
		//�½�һ��cookie����
		Cookie c = new Cookie("lastVisit",""+System.currentTimeMillis());
		//���浽�������
		response.addCookie(c);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
