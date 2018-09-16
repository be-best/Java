package com.store.web.servlet;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.PageBean;
import com.store.domain.Product;
import com.store.service.ProductService;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;
import com.store.utils.CookieUtils;
/**
 * 商品的一个Servlet
 * @author 45度炸
 *
 */
public class ProductServlet extends BaseServlet {


	/**
	 * findByCid:根据分类的ID查询某个分类下的商品（分页显示）
	 */
	public String findByCid(HttpServletRequest req,HttpServletResponse resp){
		try{
			// 接收参数:
			String cid = req.getParameter("cid");
			Integer currPage = Integer.parseInt(req.getParameter("currPage"));
			// 调用业务层:
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			PageBean<Product> pageBean = productService.findByCid(cid,currPage);
			
			req.setAttribute("pageBean", pageBean);
			return "/jsp/product_list.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
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
			//System.out.println(productKeywords);
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			PageBean<Product> pageBean = productService.searchProduct(productKeywords,currPage);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("productKeywords", Keywords);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/product_search.jsp";
	}
	
	/**
	 * findByPid:查询显示单个商品
	 */
	public String findByPid(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			request.setAttribute("product", product);
			
			//显示商品的浏览记录
			Cookie[] cookies = request.getCookies();
			//获取名称为history的cookie
			Cookie cookie = CookieUtils.findCookie(cookies, "history");
			if(cookie == null) {
				//没有浏览记录，cookie中没有信息时，新建一个cookie存入history
				Cookie c = new Cookie("history", pid);
				c.setPath("/myStore_v1.0");
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
			} else {
				//有浏览记录时
				//先判断商品在不在记录里面
				String value = cookie.getValue();
				String[] ids = value.split("-");
				//将数组转为linkedList
				LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
				//记录里包含pid,直接删除旧的然后添加到最前面
				if(list.contains(pid)) {
					list.remove(pid);
					list.addFirst(pid);
				} else {
					//记录里不包含pid,判断记录个数有没有大于6
					if(list.size() >= 6) {
						//大于6删除掉1一个再添加新的记录
						list.removeLast();
						list.addFirst(pid);
					} else {
						list.addFirst(pid);
					}
				}
				//将list集合拼接成字符串
				StringBuffer sb = new StringBuffer();
				for (String string : list) {
					sb.append(string).append("-");
				}
				String idStr = sb.substring(0, sb.length()-1);
				//存入cookie
				Cookie newCookie = new Cookie("history",idStr);
				newCookie.setPath("/myStore_v1.0");
				newCookie.setMaxAge(60*60*24*7);
				response.addCookie(newCookie);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/product_info.jsp";
		
	}
	
	/**
	 * 清除浏览记录
	 */
	public String deleteCookie(HttpServletRequest request,HttpServletResponse response) {
		//Cookie[] cookies = request.getCookies();
		//Cookie cookie = CookieUtils.findCookie(cookies, "history");
		Cookie cookie = new Cookie("history","");
		cookie.setPath("/myStore_v1.0");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "/jsp/product_list.jsp";
		
	}
	
	
}










