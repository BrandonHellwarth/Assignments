package com.BrandonHellwarth.BookClub.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BrandonHellwarth.BookClub.Models.Book;
import com.BrandonHellwarth.BookClub.Repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book updateBook(Long id, String title, String author, String my_thoughts) {
		Optional<Book> potentialBook = bookRepo.findById(id);
		if(potentialBook.isPresent()) {
			potentialBook.get().setTitle(title);
			potentialBook.get().setAuthor(author);
			potentialBook.get().setMy_thoughts(my_thoughts);
			bookRepo.save(potentialBook.get());
			return potentialBook.get();
		}
		else {
			return null;
		}
	}
	
	public Book findById(Long id) {
    	Optional<Book> potentialBook = bookRepo.findById(id);
    	if(potentialBook.isPresent()) {
    		return potentialBook.get();
    	}
    	return null;
    }
}
