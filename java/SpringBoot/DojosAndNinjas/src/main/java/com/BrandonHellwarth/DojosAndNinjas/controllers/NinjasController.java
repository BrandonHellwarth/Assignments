package com.BrandonHellwarth.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BrandonHellwarth.DojosAndNinjas.models.Ninja;
import com.BrandonHellwarth.DojosAndNinjas.services.DojoService;
import com.BrandonHellwarth.DojosAndNinjas.services.NinjaService;

@Controller
public class NinjasController {
	
	@Autowired
	NinjaService ninjaServ;
	
	@Autowired
	DojoService dojoServ;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		if(dojoServ.allDojos().isEmpty()) {
			return "redirect:/dojos/new";
		}
		model.addAttribute("dojos", dojoServ.allDojos());
		return "newNinja.jsp";
	}
	
	//ACTION ROUTES
	
	@PostMapping("/processNewNinja")
	public String processNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		ninjaServ.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
}
