package com.xin.admin.category;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xin.category.service.CategoryService;
import com.xin.entity.Category;

import povos.CategoryPovo;

@Controller
@RequestMapping("/category1")
public class AdminCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//显示类别模块
	@GetMapping("/loadCategory.action")
	public String loadCategory(Model model) {
		
		List<CategoryPovo> povos = categoryService.getCategoryPovos();
		
		model.addAttribute("categorypovos", povos);
		
		return "adminjsps/admin/book/left";
	}
	
	
	// 显示所有分类
	@GetMapping("/showCategory.action")
	public String showCategory(Model model) {

		List<CategoryPovo> povos = categoryService.getCategoryPovos();

		model.addAttribute("categorypovos", povos);

		return "adminjsps/admin/category/list";

	}
	
	
	//	添加一级分类
	@PostMapping("/add.action")
	public String add(Model model, Category category) {
		
		categoryService.add(category);
		
		
		return "redirect:/admin/getAllCategory.action";
	}
	
//	添加2级分类
	@GetMapping("/getCname.action")
	public String getCname(Model model) {
		
		List<Category> categories = categoryService.getAllCname();
		
		model.addAttribute("categorys", categories);
		
		return "adminjsps/admin/category/add2";
	}
	//	添加2级分类
	@PostMapping("/add2.action")
	public String add2(Model model, Category category) {
		
		categoryService.add2(category);
		
		return "redirect:/admin/getAllCategory.action";
	}
	
	
	//	修改一级分类
	@RequestMapping("/getCategoryByCid/{cid}.action")
	public String getCategoryByCid(@PathVariable String cid, Model model) {
		
		Category category = categoryService.selectCategoryByCid(cid);
		List<Category> categories = categoryService.getAllCname();
		
		model.addAttribute("categorys", categories);
		model.addAttribute("category", category);
		return "adminjsps/admin/category/edit";
	}
	@PostMapping("/updateCategoryFirst.action")
	public String updateCategoryFirst(Model model, Category category) {
		
		categoryService.updateCategoryFirst(category);
		
		
		return "redirect:/admin/getAllCategory.action";
	}
	
	//	修改2级分类
	@RequestMapping("/getCategoryByCid2/{cid}.action")
	public String getCategoryByCid2(@PathVariable String cid, Model model) {
		
		Category category = categoryService.selectCategoryByCid(cid);
		List<Category> categories = categoryService.getAllCname();
		
		model.addAttribute("categorys", categories);
		model.addAttribute("category", category);
		return "adminjsps/admin/category/edit2";
	}
	@PostMapping("/updateCategorySecond.action")
	public String updateCategorySecond(Model model, Category category) {
		
		categoryService.updateCategorySecond(category);
		
		
		return "redirect:/admin/getAllCategory.action";
	}
	
	
	//	删除
	@GetMapping("/removeCategoryByCid/{cid}.action")
	public String removeCategoryByCid(@PathVariable String cid, Model model) {
		
		categoryService.removeCategory(cid);
		return "redirect:/admin/getAllCategory.action";
	}
	
}
