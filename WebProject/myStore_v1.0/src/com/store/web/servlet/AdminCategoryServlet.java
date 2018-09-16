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
	 * ��̨��ѯ���з���
	 */
	public String findAll(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//����ҵ��㴦������
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
	 * ��ת����ӷ���Ľ���
	 */
	public String saveUI(HttpServletRequest request ,HttpServletResponse response) {
		return "/admin/category/add.jsp";
		
	}
	
	/**
	 * ��ӷ���
	 */
	public String save(HttpServletRequest request, HttpServletResponse response) {
		try {
			//���ղ���
			String cname = request.getParameter("cname");
			//��װ����
			Category category = new Category();
			category.setCid(UUIDUtils.getUUID());
			category.setCname(cname);
			//����ҵ��㴦������
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			categoryService.save(category);
			//�ض������ص�list����
			response.sendRedirect(request.getContextPath()+"/AdminCategoryServlet?method=findAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * �޸ķ��࣬���Ȱ�Ҫ�޸ĵķ�����ʾ���޸Ľ���
	 */
	public String edit(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
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
	 * �޸ķ���
	 */
	public String update(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
			Map<String,String[]> map = request.getParameterMap();
			Category category = new Category();
			BeanUtils.populate(category, map);
			//����ҵ��㴦������
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			categoryService.update(category);
			//�ص�list����
			response.sendRedirect(request.getContextPath()+"/AdminCategoryServlet?method=findAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * ɾ�����࣬ע�����������Ʒ�����԰���Ʒ��category���������cid��Ϊnull,Ȼ����ɾ��category
	 */
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
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












