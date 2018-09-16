package bull01.Product.ProductServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bull01.Product.ProductService.ProductService;

public class DeleteAllProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ��ѡ�еĸ�ѡ���idֵ
		String[] ids = request.getParameterValues("ids");
		//����ҵ��㴦������
		ProductService productService = new ProductService();
		productService.deleteAll(ids);
		
		request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
