package com.laurenmorgan.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurenmorgan.bookClub.models.Book;
import com.laurenmorgan.bookClub.repositories.BookRepository;

@Service
public class BookService {
	
	
	@Autowired 
	BookRepository bookRepo;
	
	
	
	 public List<Book> allBooks() {
	        return bookRepo.findAll();
	    }

	 public Book createOrUpdate(Book book) {
	        return bookRepo.save(book);
	   	}

	 public Book findOne(Long id) {
	     Optional<Book> optionalBook = bookRepo.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	

}
