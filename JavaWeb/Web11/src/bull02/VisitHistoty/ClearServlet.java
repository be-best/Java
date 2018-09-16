package bull02.VisitHistoty;
/**
 * Çå¿Õ³Ö¾ÃÐÔcookie
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("history",null);
		cookie.setPath("/Web11");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		request.getRequestDispatcher("/history/product_list.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
