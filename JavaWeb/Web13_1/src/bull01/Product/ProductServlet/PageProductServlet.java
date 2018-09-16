package bull01.Product.ProductServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull01.Product.ProductDomain.PageBean;
import bull01.Product.ProductService.ProductService;

public class PageProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			//���յ�ǰҳ��
			int currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = new ProductService();
			//����ҵ��㴦������
			PageBean pageBean = productService.pageShow(currPage);
			//ҳ����ת
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("/product/product_page.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
