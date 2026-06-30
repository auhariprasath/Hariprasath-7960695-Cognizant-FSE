package com.example.Library_management.Services;

import com.example.Library_management.Repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void displayService() {
        System.out.println("Book Service Created");
    }

}