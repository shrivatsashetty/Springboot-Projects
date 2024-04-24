package com.example.firstspringweb;

public class Book {
	
	int bookId;
	String bookTitle;
	String bookAuthor;
	Publisher publisher;

	/* constructor */
	public Book(int bookId, String bookTitle, String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}
	
	/* getters and setters */
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	// initializer method, automatically called after the object of the class is created
	public void initBook() {
		System.out.println("Init method of book class called");
	}
	
	// destroy method, called when the object goes out of scope i.e disposed by garbage collector
	public void destructor() {
		System.out.println("destructor called...");
	}
	
//	/* override the toString method to print custom string description of the objects */
//	@Override
//	public String toString() {
//		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor;
//	}
	
}
