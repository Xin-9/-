package com.xin.category.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xin.entity.Category;
import com.xin.mapper.CategoryMapper;

import povos.CategoryPovo;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	public List<CategoryPovo> getCategoryPovos() {
		//获取分类一级目录
		List<CategoryPovo> povos = categoryMapper.selectCategoryiesPidIsNull();
		
		//获取二级目录
		for (CategoryPovo categoryPovo : povos) {
			categoryPovo.setChildren(categoryMapper.selectCategoryiesByPid(categoryPovo.getCid()));
		}
		
		return povos;
	}
	
	
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.insert(category);
	}

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.selectAll();
	}

	public List<Category> getAllCname() {
		// TODO Auto-generated method stub
		return categoryMapper.selectAll();
	}


	public void add2(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.insert(category);
	}

	public Category selectCategoryByCid(String cid) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(cid);
	}

	public void updateCategoryFirst(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.updateByPrimaryKey2(category);
		
	}

	public void updateCategorySecond(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.updateByPrimaryKey3(category);
	}

	public void removeCategory(String cid) {
		// TODO Auto-generated method stub
		categoryMapper.deleteByPrimaryKey(cid);
	}
	
}
