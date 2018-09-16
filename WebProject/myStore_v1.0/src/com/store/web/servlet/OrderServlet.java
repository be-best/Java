package com.store.web.servlet;
/**
 * 订单模块的Servlet
 */
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.Cart;
import com.store.domain.CartItem;
import com.store.domain.OrderItem;
import com.store.domain.Orders;
import com.store.domain.PageBean;
import com.store.domain.User;
import com.store.service.OrderService;
import com.store.utils.BaseServlet;
import com.store.utils.BeanFactory;
import com.store.utils.PaymentUtil;
import com.store.utils.UUIDUtils;

public class OrderServlet extends BaseServlet {
	
	/**
	 * 生成订单 
	 */
	public String creatOrder(HttpServletRequest request,HttpServletResponse response) {
		//封装订单
		Orders orders = new Orders();
		orders.setOid(UUIDUtils.getUUID());//订单编号
		orders.setOrderTime(new Date());//订单时间
		orders.setState(1);//未付款
		//获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null) {
			//request.setAttribute("msg", "购物车为空");
			return "/jsp/cart.jsp";
		}
		orders.setTotal(cart.getTotal());//订单总金额
		User user = (User) request.getSession().getAttribute("existUser");
		if(user == null) {
			request.setAttribute("msg", "不好意思，您还没有登陆哟！");
			return "/jsp/login,jsp";
		}
		orders.setUser(user);//订单用户
		
		//封装订单项,订单项在购物车中,购物车是一个map集合（键是pid,值是购物车中的购物项）
		for (CartItem cartItem : cart.getMap().values()) {
			//新建一个订单项
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(UUIDUtils.getUUID()); //订单项编号
			orderItem.setCount(cartItem.getCount()); //一个订单项的商品个数
			orderItem.setSubtotal(cartItem.getSubtotal()); //订单项小计
			orderItem.setProduct(cartItem.getProduct()); //订单项商品
			orderItem.setOrders(orders);//订单项所属订单
			
			//获取orders的订单项集合list,并添加入新的orderItem
			orders.getOrderItems().add(orderItem);
		}
		
		OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
		orderService.creatOrder(orders);
		
		//清空购物车
		cart.clearCart();
		
		//将订单信息存入当前请求
		request.setAttribute("orders", orders);
		return "/jsp/order_info.jsp";
		
	}
	
	
	/**
	 * 我的所有订单
	 */
	public String findOrderByUid(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收数据
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			//获得当前登录的用户
			User user = (User) request.getSession().getAttribute("existUser");
			//调用业务层处理数据
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			PageBean<Orders> pageBean = orderService.findOrderByUid(currPage,user.getUid());
			
			List<Orders> list = pageBean.getList();
			for (Orders orders : list) {
				List<OrderItem> olist = orders.getOrderItems();
				for (OrderItem orderItem : olist) {
					if(orderItem.getProduct().getPflag() == 1) {
						orders.setTotal(0.0);
						orderItem.setSubtotal(0.0);
					}
				}
			}
			pageBean.setList(list);
			//存储到当前请求域
			request.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//转发
		return "/jsp/order_list.jsp";
		
	}
	
	/**
	 * 查询一个订单
	 */
	public String findOrderByOid(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收参数
			String oid = request.getParameter("oid");
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			Orders order = orderService.findOrderByOid(oid);
			request.setAttribute("orders", order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/order_info.jsp";
		
	}
	
	
	
	
	/**
	 * 删除订单
	 */
	public String deleteOrderByOid(HttpServletRequest request,HttpServletResponse response) {
		try {
			//接收参数
			String oid = request.getParameter("oid");
			Integer currPage = Integer.parseInt(request.getParameter("currPage")); 
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			orderService.deleteOrderByOid(oid);
		
		
			
			response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrderByUid&currPage=1");
//			//获得当前登录的用户
//			User user = (User) request.getSession().getAttribute("existUser");
//			//调用业务层处理数据
//			PageBean<Orders> pageBean = orderService.findOrderByUid(currPage,user.getUid());
//			//存储到当前请求域
//			request.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "/jsp/order_list.jsp";
		return null;
	}
	
	/**
	 * 订单支付
	 */
	public String payOrder(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收参数
			String oid = request.getParameter("oid");
			String address = request.getParameter("address");
			String name = request.getParameter("name");
			String telephone = request.getParameter("telephone");
			//支付通道参数
			String pd_FrpId = request.getParameter("pd_FrpId");
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			//更新用户信息
			Orders order = orderService.findOrderByOid(oid);
			order.setName(name);
			order.setAddress(address);
			order.setTelephone(telephone);
			orderService.updateOrder(order);
		
			//付款，跳转到网银界面
			//准备参数
			String p0_Cmd = "Buy"; //业务类型
			String p1_MerId = "10001126856";//商户编号，测试账号
			String p2_Order = oid; //订单号
			String p3_Amt = order.getTotal().toString(); //金额
			String p4_Cur = "CNY";
			String p5_Pid = "";
			String p6_Pcat = "";
			String p7_Pdesc = "";
			String p8_Url = "http://localhost:8080/store_v2.0/OrderServlet?method=callBack";
			String p9_SAF = "";
			String pa_MP = "";
			String pr_NeedResponse = "1";
			String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
			//生成一个hmac码
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
			
			//生成跳转地址
			StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
			sb.append("p0_Cmd=").append(p0_Cmd).append("&");
			sb.append("p1_MerId=").append(p1_MerId).append("&");
			sb.append("p2_Order=").append(p2_Order).append("&");
			sb.append("p3_Amt=").append(p3_Amt).append("&");
			sb.append("p4_Cur=").append(p4_Cur).append("&");
			sb.append("p5_Pid=").append(p5_Pid).append("&");
			sb.append("p6_Pcat=").append(p6_Pcat).append("&");
			sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
			sb.append("p8_Url=").append(p8_Url).append("&");
			sb.append("p9_SAF=").append(p9_SAF).append("&");
			sb.append("pa_MP=").append(pa_MP).append("&");
			sb.append("pd_FrpId=").append(pd_FrpId).append("&");
			sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
			sb.append("hmac=").append(hmac);
			
			//重定向到支付界面
			response.sendRedirect(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}
	
	/**
	 * 付款成功后
	 */
	public String callBack(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//接收参数
			String oid = request.getParameter("r6_Order");
			String money = request.getParameter("r3_Amt");
			
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			Orders order = orderService.findOrderByOid(oid);
			order.setState(2);//订单状态设置为卖家未发货
			orderService.updateOrder(order);
			
			request.setAttribute("msg1", oid);
			request.setAttribute("msg2", money);
			request.setAttribute("msg3", "<img src='${ pageContext.request.contextPath }/img/guzhang3.gif' height='300px' width='300px'>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/jsp/msg.jsp";
		
	}
	
	/**
	 * 确认收货
	 */
	public String confirmGoods(HttpServletRequest request,HttpServletResponse response) {
		try {
			String oid = request.getParameter("oid");
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			Orders order = orderService.findOrderByOid(oid);
			order.setState(4);
			orderService.updateOrder(order);
			response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrderByUid&currPage="+currPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}















