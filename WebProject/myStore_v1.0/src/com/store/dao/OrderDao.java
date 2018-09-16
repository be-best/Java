package com.store.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.store.domain.OrderItem;
import com.store.domain.Orders;

public interface OrderDao {

	void creatOrder(Connection conn, Orders orders) throws SQLException;

	void creatOrderItem(Connection conn, OrderItem orderItem) throws SQLException;

	Integer findCountByUid(String uid) throws SQLException;

	List<Orders> findOrderByUid(String uid, int begin, int pageSize) throws Exception;

	void deleteOrderByOid(String oid) throws SQLException;

	Orders findOrderByOid(String oid) throws Exception;

	void updateOrder(Orders order) throws SQLException;

	Integer findAllCount() throws SQLException;

	List<Orders> findAllOrder(int begin, int pageSize) throws SQLException;

	Integer findCountByState(Integer state) throws SQLException;

	List<Orders> findOrderByState(Integer state, int begin, int pageSize) throws SQLException;

	List<OrderItem> showDetail(String oid) throws Exception;

	Integer findCountByOidKeywords(String oidKeywords) throws SQLException;

	List<Orders> findOrderByOidKeywords(String oidKeywords, int begin,int pageSize) throws SQLException;

}
