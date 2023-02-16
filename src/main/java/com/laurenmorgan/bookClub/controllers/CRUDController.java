package com.laurenmorgan.bookClub.controllers;

import java.util.List;

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

import com.laurenmorgan.bookClub.models.Book;
import com.laurenmorgan.bookClub.models.User;
import com.laurenmorgan.bookClub.services.BookService;
import com.laurenmorgan.bookClub.services.UserService;


@Controller
public class CRUDController {
	
	@Autowired
	BookService bookServ;
	
	
	
	@Autowired
	UserService userServ;
	
	
	
	
	  @GetMapping("/home")
	     public String nextPage(Model model, HttpSession session, @ModelAttribute("user") User user,@ModelAttribute("book") Book book) {
	    	 
	    
	    	session.getAttribute("userId");	    	
	    	Long sessionId = (Long) session.getAttribute("userId");
	    	User userId = userServ.findOne(sessionId);
	    	model.addAttribute("user", userId);
	    	model.addAttribute("books", bookServ.allBooks());

	    	 //this grabs the userID 
	    	
	    	 //we need to create a list of books to pass through and display on page
	    	 
	    	 
	    	
	    	
	    	 
	    	 return "newPage.jsp";
	     }
	
	@GetMapping("/book/id")
	public String view() {
		return "bookDetails.jsp";
	}
	
	
	@GetMapping("/book/new")
	public String newBook(@ModelAttribute("book") Book book, 
						Model model,
						@ModelAttribute("user") User user, 
						BindingResult result, 
						HttpSession session) {
		
//		session.getAttribute("userId");
//    	Long sessionId = (Long) session.getAttribute("userId");
//    	User userId = userServ.findOne(sessionId);

		
		//this is easier and shorter algorithm
		User users = userServ.findOne((Long) session.getAttribute("userId"));
    	 model.addAttribute("user", users);

		
		return "newBook.jsp";
	}
	
	@PostMapping("/addBook/{userId}")
	public String createBook(@Valid @ModelAttribute("book") Book book, 
							BindingResult result, 
							Model model, HttpSession session,
							@PathVariable("userId") String userId, 
							User user) {
		
		session.getAttribute("userId");
		Long sessionId = (Long) session.getAttribute("userId");
    	
	    
   	 	User userSessionId = userServ.findOne(sessionId);
   	 	
//   	 	System.out.println(userSessionId.getId());
   	 	
   	 User users = userServ.findOne((Long) session.getAttribute("userId"));
 	 model.addAttribute("user", users);
   	 	
   	 	
        if(result.hasErrors()) {
        	
        	model.addAttribute("book",book);
            return "newBook.jsp";
        }
        
        else { 
        book.setUser(userSessionId);
        System.out.println(book.getUser());
		bookServ.createOrUpdate(book);
		
		
		return "redirect:/home";
        }
	}
	
	@GetMapping("/books/{book_id}")
	public String bookDetails(@ModelAttribute("book") Book book, 
							 Model model, 
							 @ModelAttribute("user") User user, 
							 BindingResult result, 
							 HttpSession session, @PathVariable("book_id") Long bookId) {
		
//		session.getAttribute("userId");
//    	Long sessionId = (Long) session.getAttribute("userId");
//    	User userId = userServ.findOne(sessionId);
//    	model.addAttribute("user", userId);
		
//		User users = userServ.findOne((Long) session.getAttribute("userId"));
//   	 	model.addAttribute("user", users);
//    	DONT NEED THIS ^
    	
    	model.addAttribute("book", bookServ.findOne(bookId));

		
		return "bookDetails.jsp";
	}
}
