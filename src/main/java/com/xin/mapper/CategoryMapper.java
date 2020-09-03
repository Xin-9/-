package com.xin.mapper;

import com.xin.entity.Category;

import povos.CategoryPovo;

import java.util.List;

public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Jun 23 15:02:12 CST 2020
     */
    int deleteByPrimaryKey(String cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Jun 23 15:02:12 CST 2020
     */
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Jun 23 15:02:12 CST 2020
     */
    Category selectByPrimaryKey(String cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Jun 23 15:02:12 CST 2020
     */
    List<Category> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Jun 23 15:02:12 CST 2020
     */
    int updateByPrimaryKey(Category record);

	List<CategoryPovo> selectCategoryiesPidIsNull();

	List<Category> selectCategoryiesByPid(String pid);
	
	void add(Category category);

	void updateAdd2(Category category);

	void updateByPrimaryKey2(Category category);

	void updateByPrimaryKey3(Category category);
}
