package com.laurenmorgan.bookClub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="books")
public class Book {


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
		
		//Should always do not blank for forms ? Instead of NotEmpty 
		@NotBlank(message="title is required!")
		@Size(min=3, max=30, message="title must be between 3 and 30 characters")
		private String title;
		
		
		@NotBlank(message="Author is required!")
	    @Size(min=3, max=30, message="Author must be between 3 and 30 characters")
	    private String author;
	    
		@NotBlank(message="Thoughts on this book are required!")
	    @Size(min=8, max=225, message="Thoughts must be between 8 and 225 characters")
	    private String thoughts;
	    
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private User user;
	   
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	   public Book() {
		   
	   }
	   
	   

	public Book(Long id,
		String title,
		String author,
		String thoughts,
		User user) {

		this.id = id;
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
		this.user = user;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	   

}
