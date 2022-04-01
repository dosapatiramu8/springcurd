package com.nareshit.springbootbookcurdoperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.nareshit.springbootbookcurdoperation.dto.BookRequestDto;
import com.nareshit.springbootbookcurdoperation.model.Book;

public interface BookService {

	public void saveBook(BookRequestDto bookRequestDto);

	public void updateBook(BookRequestDto bookRequestDto);

	public void deleteBook(Long bookId);

	public Optional<Book> getBookById(Long bookId);

	public List<BookRequestDto> getAllBook();

	@Query("update Book set bookName:=bookName where bookId:=bookId")
	public void updateBookByAuthor(String bookName, Long bookId);
}
