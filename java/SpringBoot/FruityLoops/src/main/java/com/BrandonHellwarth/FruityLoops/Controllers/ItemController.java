package com.BrandonHellwarth.FruityLoops.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BrandonHellwarth.FruityLoops.Models.Item;

@Controller
public class ItemController {
 
 @RequestMapping("/")
 public String index(Model model) {
     
     ArrayList<Item> fruits = new ArrayList<Item>();
     fruits.add(new Item("Kiwi", 1.5));
     fruits.add(new Item("Mango", 2.0));
     fruits.add(new Item("Goji Berries", 4.0));
     fruits.add(new Item("Guava", .75));
     fruits.add(new Item("Banana", 1.0));
     
     // Add fruits your view model here
     model.addAttribute("fruitsFromController", fruits);
     return "index.jsp";
 }
}