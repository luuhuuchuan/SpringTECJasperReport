package com.ck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ck.service.DashboardService;
import com.ck.service.DataminingService;

@Controller
public class MainController {

	@Autowired
	DashboardService dashboardService;
	
	@Autowired
	DataminingService dataminingService;

	@GetMapping("/")
	public String index(Model model) {
		dashboardService.renderReport();
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
	public String getShelf(Model model) {
		model.addAttribute("goodsInShelf", dataminingService.getGoodsInShelf());
		return "shelf";
	}
}
