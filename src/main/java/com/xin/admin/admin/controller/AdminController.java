package com.xin.admin.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xin.admin.admin.service.AdminService;
import com.xin.entity.Admin;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login.action")
	public String login(HttpSession session,Admin admin, Model model) {

		Admin a = adminService.login(admin);
		
		if (a == null) {
			model.addAttribute("msg", "用户名或密码错误");
			return "adminjsps/login";
		} 
		session.setAttribute("admin", admin);
		return "adminjsps/admin/index";
		
	}
	
	//	退出
	@GetMapping("/logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "adminjsps/login";
	}
	

}
