package com.BrandonHellwarth.BookClub.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BrandonHellwarth.BookClub.Models.Book;
import com.BrandonHellwarth.BookClub.Services.BookService;
import com.BrandonHellwarth.BookClub.Services.UserService;

@Controller
public class BookController {
	
	@Autowired
	UserService userServ;
	@Autowired
	BookService bookServ;
	
	@RequestMapping("/books/{id}")
	public String dashboard(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("books", bookServ.allBooks());
		model.addAttribute("user", userServ.findById(id));
		return "dashboard.jsp";
	}
	
	@RequestMapping("/books/new/{id}")
	public String newBook(@ModelAttribute("book") Book book, @PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.findById(id));
		return "new.jsp";
	}
	
	@RequestMapping("/books/show/{uid}/{bid}")
	public String show(@PathVariable("uid") Long uid, @PathVariable("bid") Long bid, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.findById(uid));
		model.addAttribute("book", bookServ.findById(bid));
		return "show.jsp";
	}
	
	@RequestMapping("/books/edit/{uid}/{bid}")
	public String editBook(@ModelAttribute("book") Book book, @PathVariable("uid") Long uid, @PathVariable("bid") Long bid, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.findById(uid));
		model.addAttribute("book", bookServ.findById(bid));
		return "edit.jsp";
	}
	//ACTION ROUTES
	@PostMapping("/processNewBook/{id}")
	public String processNewBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		bookServ.createBook(book);
		return "redirect:/books/" + id;
	}
	
	@PutMapping("/processEditBook/{uid}/{bid}")
	public String processEditBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("uid") Long uid, @PathVariable("bid") Long bid) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		bookServ.updateBook(bid, book.getTitle(), book.getAuthor(), book.getMy_thoughts());
		return "redirect:/books/" + uid;
	}
}
