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
			 * 判断是否重复提交
			 */
			//获取表单中的令牌
			String token1 = request.getParameter("token");
			//获取session中的令牌
			String token2 = (String) request.getSession().getAttribute("token");
			//先清空session中的令牌
			request.getSession().removeAttribute("token");
			//因为一次提交session中的token和表单中获取的token一样。如果两个token不同,说明提交了两次。
			if(!token1.equals(token2)) {
				request.setAttribute("msg","您已经提交过了，请不要重复提交！");
				request.getRequestDispatcher("/product/err.jsp").forward(request, response);
				return;//已经提交，直接return，不要继续往下执行。
			}
			
			
			//接收数据
			Map<String,String[]> map = request.getParameterMap();
			Product product = new Product();
			BeanUtils.populate(product, map);
			//接收的数据中没有上架时间，这里设置时间
			product.setPdate(new Date());
			//数据库中没有设置自动增长的序号，这里设置序号
			product.setPid(UUIDUtils.getUUID());
			
			ProductService productService = new ProductService();
			productService.add(product);
			//注意这里要跳到ProductFindAllServlet,这个Servlet再进行查询显示到product_list.jsp
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
