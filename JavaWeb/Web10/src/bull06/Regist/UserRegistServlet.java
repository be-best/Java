package bull06.Regist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			//接收数据
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("telephone");
			//封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setName(name);
			user.setSex(sex);
			user.setTelephone(telephone);
			//调用业务层处理数据
			UserService userService = new UserService();
			userService.regist(user);
			//注册后实现页面跳转
			response.sendRedirect(request.getContextPath()+"/userRegist/login.htm");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
