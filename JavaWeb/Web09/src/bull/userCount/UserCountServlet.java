package bull.userCount;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull.userLogin.User;
import bull.userLogin.UserService;

public class UserCountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Servlet创建时就初始化一个count值
	 */
	public void init() throws ServletException {
		//初始化一个count值
		int count = 0;
		//将count值存入ServletCount
		this.getServletContext().setAttribute("count", count);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//解决向页面输出的乱码问题
			response.setContentType("text/html;charset=UTF-8");
			//接收数据
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

			//业务层处理数据
			UserService userService = new UserService();
			User existUser = userService.login(user);
			//验证数据
			if(existUser == null) {
				response.getWriter().println("<h2>对不住了这位壮士，此次登录失败...</h2>");
			} else {
				response.getWriter().println("<font size='5' style='font-weight:bold;'>登录成功!欢迎这位壮士:<span style='color:blue'>"+existUser.getNickname()+"</span></font>");
				response.getWriter().println("<h3>页面将在5秒后跳转...</h3>");
				//Refresh定时跳转
				response.setHeader("Refresh", "5;url=/Web01/CountServlet");
				//设置状态码
				//response.setStatus(302);
				//Location直接跳转
				//response.setHeader("Location", "/Web01/userRefresh/success.html");
				
				//登录成功获取count值并加1，增加一次登录人次。
				int count = (int) this.getServletContext().getAttribute("count");//object类型要强转
				count++;
				this.getServletContext().setAttribute("count", count);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 一次请求过来的时候，首先调用的是service方法
	 * 然后根据你的form表单是post则调用doPost（）方法，get则调用doGet（）方法，如果不写，默认为doGet方法
	 * 所以，一般情况下，doGet（）和doPost（）是有一个要被执行的
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//form表单时post,所以这里要调用doget,因为方法都写在doget那边
		doGet(request, response);
	}

}
