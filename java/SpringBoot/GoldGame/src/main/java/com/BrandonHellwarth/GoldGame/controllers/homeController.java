package com.BrandonHellwarth.GoldGame.controllers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", new ArrayList());
//			System.out.println(session.getAttribute("gold"));
			model.addAttribute("gold", session.getAttribute("gold"));
			return "index.jsp";
		}
		model.addAttribute("activities", session.getAttribute("activities"));
		model.addAttribute("gold", session.getAttribute("gold"));
		return "index.jsp";
	}
	
	@PostMapping("/processAdd")
	public String add(@RequestParam(value="hid") int hid, HttpSession session) {
		if(hid == 0) {
			session.setAttribute("activities", )//either store an arraylist of activities or a new activity with an increment counter
			session.setAttribute("gold", ThreadLocalRandom.current().nextInt(10, 21) + (Integer)session.getAttribute("gold"));
		}
		
		else if(hid == 1) {
			session.setAttribute("gold", (Integer)session.getAttribute("gold") + ThreadLocalRandom.current().nextInt(5, 11));
		}
		
		else if(hid == 2) {
			session.setAttribute("gold", (Integer)session.getAttribute("gold") + ThreadLocalRandom.current().nextInt(2, 6));
		}
		
		return "redirect:/";
	}
}
