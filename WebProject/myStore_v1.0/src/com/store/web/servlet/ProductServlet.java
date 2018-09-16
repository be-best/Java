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
 * ��Ʒ��һ��Servlet
 * @author 45��ը
 *
 */
public class ProductServlet extends BaseServlet {


	/**
	 * findByCid:���ݷ����ID��ѯĳ�������µ���Ʒ����ҳ��ʾ��
	 */
	public String findByCid(HttpServletRequest req,HttpServletResponse resp){
		try{
			// ���ղ���:
			String cid = req.getParameter("cid");
			Integer currPage = Integer.parseInt(req.getParameter("currPage"));
			// ����ҵ���:
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
	 * findByPid:��ѯ��ʾ������Ʒ
	 */
	public String findByPid(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			request.setAttribute("product", product);
			
			//��ʾ��Ʒ�������¼
			Cookie[] cookies = request.getCookies();
			//��ȡ����Ϊhistory��cookie
			Cookie cookie = CookieUtils.findCookie(cookies, "history");
			if(cookie == null) {
				//û�������¼��cookie��û����Ϣʱ���½�һ��cookie����history
				Cookie c = new Cookie("history", pid);
				c.setPath("/myStore_v1.0");
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
			} else {
				//�������¼ʱ
				//���ж���Ʒ�ڲ��ڼ�¼����
				String value = cookie.getValue();
				String[] ids = value.split("-");
				//������תΪlinkedList
				LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
				//��¼�����pid,ֱ��ɾ���ɵ�Ȼ����ӵ���ǰ��
				if(list.contains(pid)) {
					list.remove(pid);
					list.addFirst(pid);
				} else {
					//��¼�ﲻ����pid,�жϼ�¼������û�д���6
					if(list.size() >= 6) {
						//����6ɾ����1һ��������µļ�¼
						list.removeLast();
						list.addFirst(pid);
					} else {
						list.addFirst(pid);
					}
				}
				//��list����ƴ�ӳ��ַ���
				StringBuffer sb = new StringBuffer();
				for (String string : list) {
					sb.append(string).append("-");
				}
				String idStr = sb.substring(0, sb.length()-1);
				//����cookie
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
	 * ��������¼
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










