package com.store.web.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.Product;
import com.store.service.ProductService;
import com.store.service.imple.ProductServiceImple;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;
/**
 * ��ҳ��һ��Servlet
 * @author 45��ը
 *
 */
public class IndexServlet extends BaseServlet {

	public String index(HttpServletRequest request,HttpServletResponse response) {
		try {
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			//��ʾ������Ʒ
			List<Product> hotList = productService.findByHot();
			//��ʾ������Ʒ
			List<Product> newList = productService.findByNew();
			
			
			request.setAttribute("hotList", hotList);
			request.setAttribute("newList", newList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����һ��·����BaseServlet�������ת��
		return "/jsp/index.jsp";
	}

}
