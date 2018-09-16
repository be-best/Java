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
 * 首页的一个Servlet
 * @author 45度炸
 *
 */
public class IndexServlet extends BaseServlet {

	public String index(HttpServletRequest request,HttpServletResponse response) {
		try {
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			//显示热门商品
			List<Product> hotList = productService.findByHot();
			//显示最新商品
			List<Product> newList = productService.findByNew();
			
			
			request.setAttribute("hotList", hotList);
			request.setAttribute("newList", newList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回一个路径，BaseServlet里面进行转发
		return "/jsp/index.jsp";
	}

}
