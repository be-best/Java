package com.store.service;

import java.sql.SQLException;
import java.util.List;

import com.store.domain.OrderItem;
import com.store.domain.Orders;
import com.store.domain.PageBean;

public interface OrderService {

	void creatOrder(Orders orders);

	PageBean<Orders> findOrderByUid(Integer currPage, String uid) throws Exception;

	void deleteOrderByOid(String oid) throws SQLException;

	Orders findOrderByOid(String oid) throws Exception;

	void updateOrder(Orders order) throws SQLException;

	PageBean<Orders> findAll(Integer currPage) throws SQLException;

	PageBean<Orders> findOrderByState(Integer currPage, Integer state) throws SQLException;

	

	Integer findCountByUid1(String uid) throws SQLException;

	PageBean<Orders> searchOrder(String oidKeywords, Integer currPage) throws SQLException;

	

	

	//List<OrderItem> showDetail(String oid) throws Exception;
	//Orders showDetail(String oid) throws Exception;
	

}
