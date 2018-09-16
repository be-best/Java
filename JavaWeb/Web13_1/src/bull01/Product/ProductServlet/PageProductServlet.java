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
			//接收当前页数
			int currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = new ProductService();
			//调用业务层处理数据
			PageBean pageBean = productService.pageShow(currPage);
			//页面跳转
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
