package com.store.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.store.domain.Category;
import com.store.service.CategoryService;
import com.store.service.imple.CategoryServiceImple;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;
/**
 * ����ģ���Servlet
 * @author 45��ը
 *
 */
public class CategoryServlet extends BaseServlet {
	
	/**
	 * ��ѯ���з���
	 */
	public String findAll(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//����ҵ��㴦������
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			List<Category> list = categoryService.findAll();
			//��listתΪjson
			JSONArray jsonArray = JSONArray.fromObject(list);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
