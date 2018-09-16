package com.store.web.servlet;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.store.domain.Category;
import com.store.service.CategoryService;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;
import com.store.utils.UUIDUtils;

public class AdminCategoryServlet extends BaseServlet {

	/**
	 * 后台查询所有分类
	 */
	public String findAll(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//调用业务层处理数据
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			List<Category> list = categoryService.findAll();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/category/list.jsp";
		
	}
	
	/**
	 * 跳转到添加分类的界面
	 */
	public String saveUI(HttpServletRequest request ,HttpServletResponse response) {
		return "/admin/category/add.jsp";
		
	}
	
	/**
	 * 添加分类
	 */
	public String save(HttpServletRequest request, HttpServletResponse response) {
		try {
			//接收参数
			String cname = request.getParameter("cname");
			//封装数据
			Category category = new Category();
			category.setCid(UUIDUtils.getUUID());
			category.setCname(cname);
			//调用业务层处理数据
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			categoryService.save(category);
			//重定向，最后回到list界面
			response.sendRedirect(request.getContextPath()+"/AdminCategoryServlet?method=findAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * 修改分类，首先把要修改的分类显示到修改界面
	 */
	public String edit(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String cid = request.getParameter("cid");
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			Category category = categoryService.findByCid(cid);
			request.setAttribute("category", category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/category/edit.jsp";
		
	}
	
	/**
	 * 修改分类
	 */
	public String update(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			Map<String,String[]> map = request.getParameterMap();
			Category category = new Category();
			BeanUtils.populate(category, map);
			//调用业务层处理数据
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			categoryService.update(category);
			//回到list界面
			response.sendRedirect(request.getContextPath()+"/AdminCategoryServlet?method=findAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * 删除分类，注意分类下有商品，可以把商品与category关联的外键cid改为null,然后再删除category
	 */
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String cid  = request.getParameter("cid");
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			categoryService.delete(cid);
			response.sendRedirect(request.getContextPath()+"/AdminCategoryServlet?method=findAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}












