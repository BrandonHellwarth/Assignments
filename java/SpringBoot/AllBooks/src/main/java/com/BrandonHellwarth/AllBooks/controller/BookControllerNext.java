package com.BrandonHellwarth.AllBooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.BrandonHellwarth.AllBooks.models.Book;
import com.BrandonHellwarth.AllBooks.services.BookService;

@Controller
public class BookControllerNext {
	
	@Autowired //automatically performs dependency injection
	BookService bookService;
	
	@GetMapping("/books")
	public String books(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook() {
		return "newBook.jsp";
	}
	
	@RequestMapping(value="/processNewBook", method=RequestMethod.POST)
	public String processNewBook(@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		bookService.createBook(book);
        return "redirect:/books";
	}
}
