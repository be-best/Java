package com.store.web.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.store.domain.OrderItem;
import com.store.domain.Orders;
import com.store.domain.PageBean;
import com.store.service.OrderService;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;

public class AdminOrderServlet extends BaseServlet {

	/**
	 * 后台查询订单
	 */
	public String findAll(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收参数
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			Integer state = Integer.parseInt(request.getParameter("state"));
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			PageBean<Orders> pageBean = null;
			if(state == 0) {
				pageBean = orderService.findAll(currPage);
			} else {
				pageBean = orderService.findOrderByState(currPage,state);
				pageBean.getList();
			}
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("state", state);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/admin/order/list.jsp";
		
	}
	
	/**
	 * 显示订单详情
	 */
/*	public String showDetail(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收参数
			String oid = request.getParameter("oid");
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			List<OrderItem> list = orderService.showDetail(oid);
			
			//将订单项集合转为json数据
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"orders"});
			JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
			
			request.setAttribute("list", list);
			//response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/order/orderinfo.jsp";
		
	}*/
	
	/**
	 * 显示订单详情
	 */
	public String showDetail(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收参数
			String oid = request.getParameter("oid");
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			Orders order = orderService.findOrderByOid(oid);
			
			//将订单项集合转为json数据
			
			
			request.setAttribute("orders", order);
			//response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/order/orderInfo.jsp";
		
	}
	
	/**
	 * 后台发货
	 */
	public String send(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String oid = request.getParameter("oid");
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			Orders order = orderService.findOrderByOid(oid);
			order.setState(3);
			orderService.updateOrder(order);
			response.sendRedirect(request.getContextPath()+"/AdminOrderServlet?method=findAll&state=0&currPage="+currPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 删除已完成的订单
	 *//*
	public String deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		try {
			//接受参数
			String oid = request.getParameter("oid");
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			orderService.deleteOrderByOid(oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}*/
	
	/**
	 * 后台查询订单
	 */
	public String searchOrder(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String oidKeywords = request.getParameter("oidKeywords");
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			PageBean<Orders> pageBean = orderService.searchOrder(oidKeywords,currPage);
			request.setAttribute("pageBean", pageBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/order/list.jsp";
		
	}

}














