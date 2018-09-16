package bull02.Ajax.AjaxServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull02.Ajax.AjaxService.AjaxService;
import bull02.Ajax.domain.User;

public class JqueryRegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("UTF-8");
			//����username
			String username = request.getParameter("username");
			AjaxService ajaxService = new AjaxService();
			User user = ajaxService.findUser(username);
			
			if(user == null) {
				//response.getWriter().print("<font color='green'>�û�������</font>");
				response.getWriter().print(1);
			}
			if(user != null) {
				//response.getWriter().print("<font color='red'>�û����ѱ�ռ��</font>");
				response.getWriter().print(0);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
