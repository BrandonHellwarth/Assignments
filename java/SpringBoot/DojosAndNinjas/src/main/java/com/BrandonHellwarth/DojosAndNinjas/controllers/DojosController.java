package com.BrandonHellwarth.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BrandonHellwarth.DojosAndNinjas.models.Dojo;
import com.BrandonHellwarth.DojosAndNinjas.services.DojoService;
import com.BrandonHellwarth.DojosAndNinjas.services.NinjaService;

@Controller
public class DojosController {
	
	@Autowired
	DojoService dojoServ;
	@Autowired
	NinjaService ninjaServ;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ninjas", ninjaServ.allNinjas());
		model.addAttribute("dojo", dojoServ.findDojo(id));
		return "showDojo.jsp";
	}
	
	//ACTION ROUTES
	
	@PostMapping("/processNewDojo")
	public String processNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoServ.createDojo(dojo);
		return "redirect:/dojos/" + dojo.getId();
	}
}
