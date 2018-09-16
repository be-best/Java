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
	 * ��ѯ������Ʒ
	 */
	public String findByPage(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
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
	 * ��ת�����ҳ��
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveUI(HttpServletRequest request,HttpServletResponse response) {
		try {
			//����Ҫ��ѯ���࣬��Ϊ��ӽ�����Ҫ����������ʾ�����ݿ��ѯ�ķ���
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
	 * �¼���Ʒ
	 */
	public String pushDown(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
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
	 * ��ѯ��ʾ���е��¼���Ʒ
	 */
	public String findByPushDown(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
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
	 * ��̨�ϼ���Ʒ
	 */
	public String pushUp(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//���ղ���
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
	 * �¼ܽ���ɾ����Ʒ
	 */
	public String deleteProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//ɾ����Ʒ
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
	 * ������ģ����ѯ
	 */
	public String searchProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
			String Keywords = request.getParameter("productKeywords");
			//�޸Ĺؼ���xxxΪ%x%x%x%
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
	 * ������ģ����ѯ
	 */
	public String searchOldProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
			String Keywords = request.getParameter("productKeywords");
			//�޸Ĺؼ���xxxΪ%x%x%x%
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
	 * ����Ʒ��Ϣ��ʾ���༭����׼���޸���Ʒ
	 * @param request
	 * @param response
	 * @return
	 */
	public String editProduct(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			//Ҫ��ѯ���࣬��Ϊ��ӽ�����Ҫ����������ʾ�����ݿ��ѯ�ķ���
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
	 * �޸���Ʒ
	 */
	public String updateProduct(HttpServletRequest request,HttpServletResponse response) {
		//���ղ���
		String pid = request.getParameter("pid");
		Map<String,String[]>  map = request.getParameterMap();
		return null;
		
	}
	
}









