package com.xin.mapper;

import com.xin.entity.Order;

import povos.OrderDescPovo;
import povos.OrderPovo;

import java.util.List;

public interface OrderMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	int deleteByPrimaryKey(String oid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	int insert(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	Order selectByPrimaryKey(String oid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	List<Order> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	int updateByPrimaryKey(Order record);

	List<OrderPovo> selectOrdersByUid(String uid);

	List<OrderDescPovo> selectOrderAndOrderItemsByOid(String oid);

	boolean updateOrderByOidForStatus(Order order);

	List<Order> selectOrdersByStatus(String status);

	List<OrderPovo> selectAllOrders();
}