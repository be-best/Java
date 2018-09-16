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
	 * ���ɶ���
	 */
	@Override
	public void creatOrder(Orders orders) {
		Connection conn = null;
		try {
			//������ӿ�������
			conn = C3P0JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			//1.���ɶ���
			OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
			orderDao.creatOrder(conn,orders);
			//2.���涩����
			for (OrderItem orderItem : orders.getOrderItems()) {
				//����orders�еĶ�����
				orderDao.creatOrderItem(conn,orderItem);
			}
			//�ύ����
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
	 * �鿴�ҵĶ���
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> findOrderByUid(Integer currPage, String uid) throws Exception {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//����ÿҳ�洢�Ķ�������
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		//���ö����ܸ���
		Integer totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		//���ö�����ҳ��
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//���ö�������
		int begin = (currPage-1)*pageSize;
		List<Orders> list = orderDao.findOrderByUid(uid,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * ɾ������
	 * @throws SQLException 
	 */
	@Override
	public void deleteOrderByOid(String oid) throws SQLException {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		orderDao.deleteOrderByOid(oid);
	}

	/**
	 * ��ѯ��������
	 * @throws Exception 
	 */
	@Override
	public Orders findOrderByOid(String oid) throws Exception {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		Orders order = orderDao.findOrderByOid(oid);
		return order;
	}

	/**
	 * ���¶�����Ϣ
	 * @throws SQLException 
	 */
	@Override
	public void updateOrder(Orders order) throws SQLException {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		orderDao.updateOrder(order);
		
	}

	/**
	 * ��̨��ѯ���ж���
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> findAll(Integer currPage) throws SQLException {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//����ÿҳ�洢�Ķ�������
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//���ö����ܸ���
		Integer totalCount = orderDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		//���ö�����ҳ��
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//���ö�������
		int begin = (currPage-1)*pageSize;
		List<Orders> list = orderDao.findAllOrder(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * ��̨����״̬��ѯ����
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> findOrderByState(Integer currPage, Integer state) throws SQLException {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//����ÿҳ�洢�Ķ�������
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//���ö����ܸ���
		Integer totalCount = orderDao.findCountByState(state);
		pageBean.setTotalCount(totalCount);
		//���ö�����ҳ��
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//���ö�������
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
	 * ģ����ѯ����
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Orders> searchOrder(String oidKeywords, Integer currPage) throws SQLException {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//����ÿҳ�洢�Ķ�������
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		//���ö����ܸ���
		Integer totalCount = orderDao.findCountByOidKeywords(oidKeywords);
		pageBean.setTotalCount(totalCount);
		//���ö�����ҳ��
		double totalC = totalCount;
		Double totalP = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalP.intValue());
		//���ö�������
		int begin = (currPage-1)*pageSize;
		List<Orders> list = orderDao.findOrderByOidKeywords(oidKeywords,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	/**
	 * ��ѯ��������
	 * @throws SQLException 
	 */
	/*@Override
	public List<OrderItem> showDetail(String oid) throws Exception {
		OrderDao orderDao = (OrderDao) BeanFactory.getBean("orderDao");
		List<OrderItem> list = orderDao.showDetail(oid);
		return list;
	}*/

	
	


}













