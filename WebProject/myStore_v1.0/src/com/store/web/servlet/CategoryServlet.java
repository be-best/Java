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
 * 分类模块的Servlet
 * @author 45度炸
 *
 */
public class CategoryServlet extends BaseServlet {
	
	/**
	 * 查询所有分类
	 */
	public String findAll(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//调用业务层处理数据
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			List<Category> list = categoryService.findAll();
			//将list转为json
			JSONArray jsonArray = JSONArray.fromObject(list);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
