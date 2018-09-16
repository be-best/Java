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
			//������Ҫ�޸���Ʒ��id,
			String id = request.getParameter("pid");
			//����ҵ��㴦������
			ProductService productService = new ProductService();
			Product product = productService.findById(id);
			//�ǵð�product�浽��ǰ�������У�����
			request.setAttribute("product", product);
			//ҳ����ת
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
