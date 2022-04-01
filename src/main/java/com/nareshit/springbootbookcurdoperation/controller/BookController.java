package com.nareshit.springbootbookcurdoperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.springbootbookcurdoperation.dto.BookRequestDto;
import com.nareshit.springbootbookcurdoperation.model.Book;
import com.nareshit.springbootbookcurdoperation.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/save")
	public ResponseEntity<String> saveBookRecords(@RequestBody BookRequestDto bookRequestDto) {
		System.out.println(bookRequestDto);
		if (bookRequestDto.getAuthorName() != null && bookRequestDto.getBookName()!=null ) {
			bookService.saveBook(bookRequestDto);
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<>("FAILER", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PutMapping(value = "/update")
	public ResponseEntity<String> updateBookRecords(@RequestBody BookRequestDto bookRequestDto) {
		if (bookRequestDto != null) {
			bookService.updateBook(bookRequestDto);
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<>("FAILER", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@DeleteMapping(value = "/delete/{bookId}")
	public ResponseEntity<String> removeBookRecords(@PathVariable(value = "bookId") String bookId) {
		if (bookId != null) {
			bookService.deleteBook(Long.valueOf(bookId));
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<>("FAILER", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/getBook/{bookId}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable("bookId") String bookId) {
		if (bookId != null) {
			bookService.getBookById(Long.valueOf(bookId));
			return new ResponseEntity<Optional<Book>>(HttpStatus.OK);
		}
		return new ResponseEntity<Optional<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/updateByAuthor")
	public ResponseEntity<String> updateBookByAuthorAndBookId(@RequestBody BookRequestDto bookRequestDto) {
		if (bookRequestDto != null) {
			bookService.updateBookByAuthor(bookRequestDto.getAuthorName(), bookRequestDto.getBookId());
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<>("FAILER", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping(value = "/getAllBook")
	public ResponseEntity<List<BookRequestDto>> getAllBookRecords() {
		return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
	}

}
