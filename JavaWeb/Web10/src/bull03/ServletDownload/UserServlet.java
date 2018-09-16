package bull03.ServletDownload;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
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
//			System.out.println(existUser.getUsername());
//			System.out.println(existUser.getPassword());
			//验证数据
			if(existUser == null) {
				//response.getWriter().println("<h2>登录失败,用户名或密码错误！</h2>");
				//request.setAttribute("msg", "<font style='color:red'>用户名或者密码错误！</font>");
				request.setAttribute("msg", "<h5 style='color:red'>用户名或者密码错误！</h5>");
				request.getRequestDispatcher("/userLogin/login.jsp").forward(request, response);
			} else {
				//response.getWriter().println("<font size='6' style='font-weight:bold;'>登陆成功，欢迎您：<span style='color:blue'>"+existUser.getNickname()+"</span></font>");
				response.setStatus(302);
				response.setHeader("Location", "/Web10/userLogin/success.html");
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
