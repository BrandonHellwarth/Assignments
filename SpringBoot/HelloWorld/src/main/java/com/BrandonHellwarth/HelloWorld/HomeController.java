package com.BrandonHellwarth.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "Hello asdaldnkj";
	}
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
}
