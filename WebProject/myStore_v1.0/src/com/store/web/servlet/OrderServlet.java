package com.store.web.servlet;
/**
 * ����ģ���Servlet
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
	 * ���ɶ��� 
	 */
	public String creatOrder(HttpServletRequest request,HttpServletResponse response) {
		//��װ����
		Orders orders = new Orders();
		orders.setOid(UUIDUtils.getUUID());//�������
		orders.setOrderTime(new Date());//����ʱ��
		orders.setState(1);//δ����
		//��ȡ���ﳵ
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null) {
			//request.setAttribute("msg", "���ﳵΪ��");
			return "/jsp/cart.jsp";
		}
		orders.setTotal(cart.getTotal());//�����ܽ��
		User user = (User) request.getSession().getAttribute("existUser");
		if(user == null) {
			request.setAttribute("msg", "������˼������û�е�½Ӵ��");
			return "/jsp/login,jsp";
		}
		orders.setUser(user);//�����û�
		
		//��װ������,�������ڹ��ﳵ��,���ﳵ��һ��map���ϣ�����pid,ֵ�ǹ��ﳵ�еĹ����
		for (CartItem cartItem : cart.getMap().values()) {
			//�½�һ��������
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(UUIDUtils.getUUID()); //��������
			orderItem.setCount(cartItem.getCount()); //һ�����������Ʒ����
			orderItem.setSubtotal(cartItem.getSubtotal()); //������С��
			orderItem.setProduct(cartItem.getProduct()); //��������Ʒ
			orderItem.setOrders(orders);//��������������
			
			//��ȡorders�Ķ������list,��������µ�orderItem
			orders.getOrderItems().add(orderItem);
		}
		
		OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
		orderService.creatOrder(orders);
		
		//��չ��ﳵ
		cart.clearCart();
		
		//��������Ϣ���뵱ǰ����
		request.setAttribute("orders", orders);
		return "/jsp/order_info.jsp";
		
	}
	
	
	/**
	 * �ҵ����ж���
	 */
	public String findOrderByUid(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//��������
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			//��õ�ǰ��¼���û�
			User user = (User) request.getSession().getAttribute("existUser");
			//����ҵ��㴦������
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
			//�洢����ǰ������
			request.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//ת��
		return "/jsp/order_list.jsp";
		
	}
	
	/**
	 * ��ѯһ������
	 */
	public String findOrderByOid(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//���ղ���
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
	 * ɾ������
	 */
	public String deleteOrderByOid(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ղ���
			String oid = request.getParameter("oid");
			Integer currPage = Integer.parseInt(request.getParameter("currPage")); 
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			orderService.deleteOrderByOid(oid);
		
		
			
			response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrderByUid&currPage=1");
//			//��õ�ǰ��¼���û�
//			User user = (User) request.getSession().getAttribute("existUser");
//			//����ҵ��㴦������
//			PageBean<Orders> pageBean = orderService.findOrderByUid(currPage,user.getUid());
//			//�洢����ǰ������
//			request.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "/jsp/order_list.jsp";
		return null;
	}
	
	/**
	 * ����֧��
	 */
	public String payOrder(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//���ղ���
			String oid = request.getParameter("oid");
			String address = request.getParameter("address");
			String name = request.getParameter("name");
			String telephone = request.getParameter("telephone");
			//֧��ͨ������
			String pd_FrpId = request.getParameter("pd_FrpId");
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			//�����û���Ϣ
			Orders order = orderService.findOrderByOid(oid);
			order.setName(name);
			order.setAddress(address);
			order.setTelephone(telephone);
			orderService.updateOrder(order);
		
			//�����ת����������
			//׼������
			String p0_Cmd = "Buy"; //ҵ������
			String p1_MerId = "10001126856";//�̻���ţ������˺�
			String p2_Order = oid; //������
			String p3_Amt = order.getTotal().toString(); //���
			String p4_Cur = "CNY";
			String p5_Pid = "";
			String p6_Pcat = "";
			String p7_Pdesc = "";
			String p8_Url = "http://localhost:8080/store_v2.0/OrderServlet?method=callBack";
			String p9_SAF = "";
			String pa_MP = "";
			String pr_NeedResponse = "1";
			String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
			//����һ��hmac��
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
			
			//������ת��ַ
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
			
			//�ض���֧������
			response.sendRedirect(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}
	
	/**
	 * ����ɹ���
	 */
	public String callBack(HttpServletRequest request ,HttpServletResponse response) {
		try {
			//���ղ���
			String oid = request.getParameter("r6_Order");
			String money = request.getParameter("r3_Amt");
			
			OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
			Orders order = orderService.findOrderByOid(oid);
			order.setState(2);//����״̬����Ϊ����δ����
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
	 * ȷ���ջ�
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















