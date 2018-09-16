package bull01.VisitTime;
/*
 * 获得浏览器中带过来的所有的Cookie信息,从数组中查找有没有指定名称的Cookie
 * 判断用户是否是第一次访问:(从数组中没有找到指定名称的Cookie)
 * * 如果是第一次:显示欢迎,记录当前访问的时间存入到Cookie中.
 * * 如果不是第一次:显示欢迎,上一次访问时间,同时记录当前访问的时间存入到Cookie中。
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
		//解决向页面输出的乱码问题
		response.setContentType("text/html;charset=UTF-8");
		//获取count值，原本是object类型要强转。
		int count = (int) this.getServletContext().getAttribute("count");
		
		//获得浏览器带过来的所有cookies
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtils.find(cookies, "lastVisit");
		//判断是否是第一次
		if(cookie == null) {
			response.getWriter().print("<font size='3' style='font-weight:bold;'>Welcome！此次是本网站的第<span style='color:red'>"+count+"</span>次用户登录！</font>");
		} else {
			//不是第一次
			Long l = Long.parseLong(cookie.getValue());
			Date date = new Date(l);
			response.getWriter().print("<font size='3' style='font-weight:bold;'>Welcome！此次是本网站的第<span style='color:red'>"+count+"</span>次用户登录！       上次登录时间是："+date.toLocaleString()+"</font>");
		}
		//新建一个cookie对象
		Cookie c = new Cookie("lastVisit",""+System.currentTimeMillis());
		//保存到浏览器端
		response.addCookie(c);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
