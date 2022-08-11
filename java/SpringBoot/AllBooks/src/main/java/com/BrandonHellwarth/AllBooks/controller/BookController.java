package com.BrandonHellwarth.AllBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.BrandonHellwarth.AllBooks.models.Book;
import com.BrandonHellwarth.AllBooks.services.BookService;

@Controller
public class BookController {
	
	@Autowired //automatically performs dependency injection
	BookService bookService;
	
	@GetMapping("/test/books/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "index.jsp";
	}
}
