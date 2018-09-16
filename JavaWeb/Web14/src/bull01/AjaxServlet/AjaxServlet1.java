package bull01.AjaxServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.getWriter().print("Hello AJAX GET!name="+name+"   "+"pass="+pass);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request,response);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.getWriter().print("Hello AJAX POST!name="+name+"   "+"pass="+pass);
	}

}
