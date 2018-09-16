package bull01.Product.ProductServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull01.Product.ProductDomain.Product;
import bull01.Product.ProductService.ProductService;

public class EditProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//接收所要修改商品的id,
			String id = request.getParameter("pid");
			//调用业务层处理数据
			ProductService productService = new ProductService();
			Product product = productService.findById(id);
			//记得把product存到当前请求域中！！！
			request.setAttribute("product", product);
			//页面跳转
			request.getRequestDispatcher("/product/update.jsp").forward(request, response);
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
