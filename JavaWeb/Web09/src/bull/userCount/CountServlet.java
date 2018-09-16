package bull.userCount;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决向页面输出的乱码问题
		response.setContentType("text/html;charset=UTF-8");
		//获取count值，原本是object类型要强转。
		int count = (int) this.getServletContext().getAttribute("count");
		response.getWriter().print("<font size='5' style='font-weight:bold;'>Welcome！此次是本网站的第<span style='color:red'>"+count+"</span>次用户登录！</font>");
		//response.getWriter().println("<font size='5' style='font-weight:bold;'>登录成功!欢迎这位壮士:<span style='color:blue'>"+existUser.getNickname()+"</span></font>");

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
