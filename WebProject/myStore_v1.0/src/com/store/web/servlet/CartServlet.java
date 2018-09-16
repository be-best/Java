package com.store.web.servlet;
/**
 * 购物车的Servlet
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
	 * 添加商品到购物车
	 */
	public String addCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收pid
			String pid = request.getParameter("pid");
			//接收count，数量
			Integer count = Integer.parseInt(request.getParameter("count"));
			//先判断有没有登陆，没登陆跳转到登陆界面
			User user = (User) request.getSession().getAttribute("existUser");
			if(user == null) {
				request.setAttribute("msg", "不好意思，您还没登陆哟！");
				return "/jsp/login.jsp";
			}
			//封装cartItem
			CartItem cartItem = new CartItem();
			cartItem.setCount(count);//设置商品数量
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			cartItem.setProduct(product);//设置商品product
			
			//添加到购物车，不能直接new购物车，要从session中获取
			Cart cart = getCart(request);
			cart.addCart(cartItem);
			
			//页面跳转，重定向
			response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
	
	/**
	 * 清除购物车
	 */
	public String clearCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			//先从session中获取cart
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
	 * 清除单个购物项
	 */
	public String clearCartItem(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收pid
			String pid = request.getParameter("pid");
			//从session中获取购物车
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
	 * 从session中获取购物车对象
	 * @param request
	 * @return
	 */
	private Cart getCart(HttpServletRequest request) {
		//获取session
		HttpSession session = request.getSession();
		//从session中获取名称为cart的cart对象
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			//如果cart为空，那么新建一个cart对象并存入session中
			 cart = new Cart();
			session.setAttribute("cart", cart);
		} 
		return cart;
	}
}












