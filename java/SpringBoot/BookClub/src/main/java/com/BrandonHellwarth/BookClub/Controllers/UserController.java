package com.BrandonHellwarth.BookClub.Controllers;

import javax.servlet.http.HttpSession;
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

import com.BrandonHellwarth.BookClub.Models.LoginUser;
import com.BrandonHellwarth.BookClub.Models.User;
import com.BrandonHellwarth.BookClub.Repositories.UserRepository;
import com.BrandonHellwarth.BookClub.Services.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userServ;
	@Autowired
	UserRepository userRepo;
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userLogin", new LoginUser());
		return "index.jsp";
	}
	
	
	@RequestMapping("/dashboard/{id}")
	public String dashboard(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.findById(id));
		return "dashboard.jsp";
	}
	
	//ACTION ROUTES
	@PostMapping("/processRegister")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userServ.register(user, result);
		if(result.hasErrors()) {
			model.addAttribute("userLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user", user);
		return "redirect:/dashboard/" + user.getId();
	}
	
	
	@PostMapping("/processLogin")
	public String login(@Valid @ModelAttribute("userLogin") LoginUser userLogin, BindingResult result, Model model, HttpSession session) {
		userServ.login(userLogin, result);
		if(result.hasErrors()) {
            model.addAttribute("user", new User());
            return "index.jsp";
        }
		User user = userRepo.findByEmail(userLogin.getEmail()).get();
		session.setAttribute("user", user);
		return "redirect:/dashboard/" + userRepo.findByEmail(userLogin.getEmail()).get().getId();
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
}
