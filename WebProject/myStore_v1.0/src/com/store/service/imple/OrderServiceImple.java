package com.store.service.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.store.dao.OrderDao;
import com.store.domain.OrderItem;
import com.store.domain.Orders;
import com.store.domain.PageBean;
import com.store.service.OrderService;
import com.store.utils.BeanFactory;
import com.store.utils.C3P0JDBCUtils;

public class OrderServiceImple implements OrderService {

	/**
	 * 生成订单
	 */
	@Override
	public void creatOrder(Orders orders) {
		Connection conn = null;
		try {
			//获得连接开启事务
			conn = C3P0JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			//1.生成订单
			OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
			orderDao.creatOrder(conn,orders);
			//2.保存订单项
			for (OrderItem orderItem : orders.getOrderItems()) {
				//遍历orders中的订单项
				orderDao.creatOrderItem(conn,orderItem);
			}
			//提交事务
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * 查看我的订单
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> findOrderByUid(Integer currPage, String uid) throws Exception {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//设置当前页
		pageBean.setCurrPage(currPage);
		//设置每页存储的订单个数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		//设置订单总个数
		Integer totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		//设置订单总页数
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//设置订单集合
		int begin = (currPage-1)*pageSize;
		List<Orders> list = orderDao.findOrderByUid(uid,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 删除订单
	 * @throws SQLException 
	 */
	@Override
	public void deleteOrderByOid(String oid) throws SQLException {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		orderDao.deleteOrderByOid(oid);
	}

	/**
	 * 查询单个订单
	 * @throws Exception 
	 */
	@Override
	public Orders findOrderByOid(String oid) throws Exception {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		Orders order = orderDao.findOrderByOid(oid);
		return order;
	}

	/**
	 * 更新订单信息
	 * @throws SQLException 
	 */
	@Override
	public void updateOrder(Orders order) throws SQLException {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		orderDao.updateOrder(order);
		
	}

	/**
	 * 后台查询所有订单
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> findAll(Integer currPage) throws SQLException {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//设置当前页
		pageBean.setCurrPage(currPage);
		//设置每页存储的订单个数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//设置订单总个数
		Integer totalCount = orderDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		//设置订单总页数
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//设置订单集合
		int begin = (currPage-1)*pageSize;
		List<Orders> list = orderDao.findAllOrder(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 后台根据状态查询订单
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> findOrderByState(Integer currPage, Integer state) throws SQLException {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//设置当前页
		pageBean.setCurrPage(currPage);
		//设置每页存储的订单个数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//设置订单总个数
		Integer totalCount = orderDao.findCountByState(state);
		pageBean.setTotalCount(totalCount);
		//设置订单总页数
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//设置订单集合
		int begin = (currPage-1)*pageSize;
		List<Orders> list = orderDao.findOrderByState(state,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Integer findCountByUid1(String uid) throws SQLException {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		return orderDao.findCountByUid(uid);
	}

	/**
	 * 模糊查询订单
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> searchOrder(String oidKeywords, Integer currPage) throws SQLException {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//设置当前页
		pageBean.setCurrPage(currPage);
		//设置每页存储的订单个数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		//设置订单总个数
		Integer totalCount = orderDao.findCountByOidKeywords(oidKeywords);
		pageBean.setTotalCount(totalCount);
		//设置订单总页数
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//设置订单集合
		int begin = (currPage-1)*pageSize;
		List<Orders> list = orderDao.findOrderByOidKeywords(oidKeywords,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	/**
	 * 查询订单详情
	 * @throws SQLException 
	 */
	/*@Override
	public List<OrderItem> showDetail(String oid) throws Exception {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		List<OrderItem> list = orderDao.showDetail(oid);
		return list;
	}*/

	
	


}













