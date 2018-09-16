package bull02.Ajax.AjaxServlet;
/**
 * ʹ��JQ��ɷ°ٶ���ʾҳ��
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull02.Ajax.AjaxService.ContentService;
import bull02.Ajax.domain.Content;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			//�����ı��������ֵ
			String content = request.getParameter("content");
			System.out.println(content);
			ContentService contentService = new ContentService();
			List<Content> list = contentService.findContent(content);
//			for (Content content2 : list) {
//				System.out.println(content2.getContent());
//			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/ajaxsearch/info.jsp").forward(request, response);
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
