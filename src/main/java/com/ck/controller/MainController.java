package com.ck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ck.service.DashboardService;

@Controller
public class MainController {

	@Autowired
	DashboardService dashboardService;

	@GetMapping("/")
	public String index(Model model) {
		dashboardService.renderReport();
		String imagePath = this.getClass().getResource("/static/reports").getFile() + "/ReportTest.png";
		model.addAttribute("imgReport1", imagePath);
		return "index";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/shelf")
	public String getShelf() {
		return "shelf";
	}
}
