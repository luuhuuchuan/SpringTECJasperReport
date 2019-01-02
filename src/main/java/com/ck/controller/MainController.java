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
//		String imagePath1 = this.getClass().getResource("/static/reports").getFile() + "/Report1.png";
//		String imagePath2 = this.getClass().getResource("/static/reports").getFile() + "/Report2.png";
//		String imagePath3 = this.getClass().getResource("/static/reports").getFile() + "/Report3.png";
//		model.addAttribute("imgReport1", imagePath1);
//		model.addAttribute("imgReport2", imagePath2);
//		model.addAttribute("imgReport3", imagePath3);
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
