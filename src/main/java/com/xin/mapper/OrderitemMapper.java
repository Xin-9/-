package com.xin.mapper;

import com.xin.entity.Orderitem;
import java.util.List;

public interface OrderitemMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table orderitem
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	int deleteByPrimaryKey(String orderitemid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table orderitem
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	int insert(Orderitem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table orderitem
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	Orderitem selectByPrimaryKey(String orderitemid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table orderitem
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	List<Orderitem> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table orderitem
	 *
	 * @mbggenerated Tue Jun 23 15:02:12 CST 2020
	 */
	int updateByPrimaryKey(Orderitem record);

	List<Orderitem> selectOrderitemsByOid(String oid);
	
	void batchInsert(List<Orderitem> orderitems);
}