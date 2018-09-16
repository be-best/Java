package com.store.web.servlet;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.Category;
import com.store.domain.PageBean;
import com.store.domain.Product;
import com.store.service.CategoryService;
import com.store.service.ProductService;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;

public class AdminProductServlet extends BaseServlet {

	/**
	 * 查询所有商品
	 */
	public String findByPage(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			PageBean<Product> pageBean = productService.findByPage(currPage);
			request.setAttribute("pageBean", pageBean);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/product/list.jsp";
		
	}
	
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveUI(HttpServletRequest request,HttpServletResponse response) {
		try {
			//首先要查询分类，因为添加界面需要有下拉框显示从数据库查询的分类
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			List<Category> list = categoryService.findAll();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/product/add.jsp";
		
	}
	
	/**
	 * 下架商品
	 */
	public String pushDown(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			product.setPflag(1);
			productService.pushDown(product);
			response.sendRedirect(request.getContextPath()+"/AdminProductServlet?method=findByPage&currPage=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 查询显示所有的下架商品
	 */
	public String findByPushDown(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			PageBean pageBean = productService.findByPushDown(currPage);
			request.setAttribute("pageBean", pageBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/product/pushDown_list.jsp";
		
	}
	
	/**
	 * 后台上架商品
	 */
	public String pushUp(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收参数
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			product.setPflag(0);
			productService.pushUp(product);
			response.sendRedirect(request.getContextPath()+"/AdminProductServlet?method=findByPushDown&currPage=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 下架界面删除商品
	 */
	public String deleteProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//删除商品
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			//Product product = productService.findByPid(pid);
			//productService.setPidAtOrderItem(pid);
			productService.deleteProduct(pid);
			response.sendRedirect(request.getContextPath()+"/AdminProductServlet?method=findByPushDown&currPage=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * 搜索框模糊查询
	 */
	public String searchProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String Keywords = request.getParameter("productKeywords");
			//修改关键词xxx为%x%x%x%
			int length = Keywords.length();
			char[] productKw = Keywords.toCharArray();
			String productKeywords = "%";
			for(int i = 0;i<length;i++) {
				productKeywords = productKeywords+productKw[i]+"%";
			}
			
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			PageBean<Product> pageBean = productService.searchProduct(productKeywords,currPage);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("productKeywords", Keywords);
			List<Product> list = pageBean.getList();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "";
		return "/admin/product/search.jsp";
	}
	
	/**
	 * 搜索框模糊查询
	 */
	public String searchOldProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String Keywords = request.getParameter("productKeywords");
			//修改关键词xxx为%x%x%x%
			int length = Keywords.length();
			char[] productKw = Keywords.toCharArray();
			String productKeywords = "%";
			for(int i = 0;i<length;i++) {
				productKeywords = productKeywords+productKw[i]+"%";
			}
			
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			PageBean<Product> pageBean = productService.searchOldProduct(productKeywords,currPage);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("productKeywords", Keywords);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/product/search_down.jsp";
	}
	
	/**
	 * 把商品信息显示到编辑界面准备修改商品
	 * @param request
	 * @param response
	 * @return
	 */
	public String editProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			//要查询分类，因为添加界面需要有下拉框显示从数据库查询的分类
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			List<Category> list = categoryService.findAll();
			request.setAttribute("list", list);
			request.setAttribute("product", product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/product/edit.jsp";
		
	}
	
	/**
	 * 修改商品
	 */
	public String updateProduct(HttpServletRequest request,HttpServletResponse response) {
		//接收参数
		String pid = request.getParameter("pid");
		Map<String,String[]>  map = request.getParameterMap();
		return null;
		
	}
	
}









