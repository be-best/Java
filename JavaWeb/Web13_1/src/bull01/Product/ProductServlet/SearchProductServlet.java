package bull01.Product.ProductServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull01.Product.ProductDomain.Product;
import bull01.Product.ProductService.ProductService;

public class SearchProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			//接收数据
			String pname = request.getParameter("pname");
			//调用业务层处理数据
			ProductService productService = new ProductService();
			List<Product> list = productService.search(pname);
			//页面跳转,将查询结果显示到product_list.jsp
			request.setAttribute("list", list);
			request.getRequestDispatcher("/product/product_list.jsp").forward(request, response);
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
