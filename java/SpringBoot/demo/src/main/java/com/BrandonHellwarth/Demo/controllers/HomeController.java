package com.BrandonHellwarth.Demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//	@RequestMapping("/")
//	public String index() {
//		return "Hello there!";
//	}
//	@RequestMapping("/pizza/{topping}")
//	public String pizza(@PathVariable("topping") String topping) {
//		return "I like Pizza with " + topping + "!";
//	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
}