package com.BrandonHellwarth.AllBooks.services;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BrandonHellwarth.AllBooks.models.Book;
import com.BrandonHellwarth.AllBooks.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // Updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages){
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            optionalBook.get().setTitle(title);
            optionalBook.get().setDescription(desc);
            optionalBook.get().setLanguage(lang);
            optionalBook.get().setNumberOfPages(numOfPages);
            return bookRepository.save(optionalBook.get());
        } else {
            return null;
        }
    }
    //Deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
