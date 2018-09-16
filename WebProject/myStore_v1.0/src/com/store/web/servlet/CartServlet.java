package com.store.web.servlet;
/**
 * ���ﳵ��Servlet
 */
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.domain.Cart;
import com.store.domain.CartItem;
import com.store.domain.Product;
import com.store.domain.User;
import com.store.service.ProductService;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;

public class CartServlet extends BaseServlet {
	
	/**
	 * �����Ʒ�����ﳵ
	 */
	public String addCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			//����pid
			String pid = request.getParameter("pid");
			//����count������
			Integer count = Integer.parseInt(request.getParameter("count"));
			//���ж���û�е�½��û��½��ת����½����
			User user = (User) request.getSession().getAttribute("existUser");
			if(user == null) {
				request.setAttribute("msg", "������˼������û��½Ӵ��");
				return "/jsp/login.jsp";
			}
			//��װcartItem
			CartItem cartItem = new CartItem();
			cartItem.setCount(count);//������Ʒ����
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			cartItem.setProduct(product);//������Ʒproduct
			
			//��ӵ����ﳵ������ֱ��new���ﳵ��Ҫ��session�л�ȡ
			Cart cart = getCart(request);
			cart.addCart(cartItem);
			
			//ҳ����ת���ض���
			response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
	
	/**
	 * ������ﳵ
	 */
	public String clearCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			//�ȴ�session�л�ȡcart
			Cart cart = getCart(request);
			cart.clearCart();
			response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * �������������
	 */
	public String clearCartItem(HttpServletRequest request,HttpServletResponse response) {
		try {
			//����pid
			String pid = request.getParameter("pid");
			//��session�л�ȡ���ﳵ
			Cart cart = getCart(request);
			cart.clearCartItem(pid);
			response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

	/**
	 * ��session�л�ȡ���ﳵ����
	 * @param request
	 * @return
	 */
	private Cart getCart(HttpServletRequest request) {
		//��ȡsession
		HttpSession session = request.getSession();
		//��session�л�ȡ����Ϊcart��cart����
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			//���cartΪ�գ���ô�½�һ��cart���󲢴���session��
			 cart = new Cart();
			session.setAttribute("cart", cart);
		} 
		return cart;
	}
}












