package bull04.Code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull01.VisitTime.User;
import bull01.VisitTime.UserService;

public class UserCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//获取提交的表单中的code
			String code1 = request.getParameter("code");
			//获取Session中的code
			String code2 = (String) request.getSession().getAttribute("code");
			//清除Session中的code
			request.getSession().removeAttribute("code");
			
			if(!code1.equals(code2)) {
				request.setAttribute("err", "<font style='color:red'>验证码输入不正确</font>");
				request.getRequestDispatcher("/code/login.jsp").forward(request, response);
				return ;
			}
			
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
				
				//设置状态码
				response.setStatus(302);
				//Location直接跳转
				response.setHeader("Location", "/Web11/code/success.html");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
