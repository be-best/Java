package bull01.Product.ProductServlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bull01.Product.ProductDomain.Product;
import bull01.Product.ProductService.ProductService;

public class UpdateProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			//接收数据
			Map<String,String[]> map = request.getParameterMap();
			Product product = new Product();
			BeanUtils.populate(product, map);
			product.setPdate(new Date());
			//调用业务层处理数据
			ProductService productService = new ProductService();
			productService.update(product);
			
			request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
