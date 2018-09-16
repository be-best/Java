package bull01.Product.ProductServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bull.utils.UUIDUtils;
import bull01.Product.ProductDomain.Product;
import bull01.Product.ProductService.ProductService;

public class AddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			/**
			 * �ж��Ƿ��ظ��ύ
			 */
			//��ȡ���е�����
			String token1 = request.getParameter("token");
			//��ȡsession�е�����
			String token2 = (String) request.getSession().getAttribute("token");
			//�����session�е�����
			request.getSession().removeAttribute("token");
			//��Ϊһ���ύsession�е�token�ͱ��л�ȡ��tokenһ�����������token��ͬ,˵���ύ�����Ρ�
			if(!token1.equals(token2)) {
				request.setAttribute("msg","���Ѿ��ύ���ˣ��벻Ҫ�ظ��ύ��");
				request.getRequestDispatcher("/product/err.jsp").forward(request, response);
				return;//�Ѿ��ύ��ֱ��return����Ҫ��������ִ�С�
			}
			
			
			//��������
			Map<String,String[]> map = request.getParameterMap();
			Product product = new Product();
			BeanUtils.populate(product, map);
			//���յ�������û���ϼ�ʱ�䣬��������ʱ��
			product.setPdate(new Date());
			//���ݿ���û�������Զ���������ţ������������
			product.setPid(UUIDUtils.getUUID());
			
			ProductService productService = new ProductService();
			productService.add(product);
			//ע������Ҫ����ProductFindAllServlet,���Servlet�ٽ��в�ѯ��ʾ��product_list.jsp
			request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
