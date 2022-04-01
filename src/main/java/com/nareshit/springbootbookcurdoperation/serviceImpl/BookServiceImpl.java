package com.nareshit.springbootbookcurdoperation.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.springbootbookcurdoperation.dto.BookRequestDto;
import com.nareshit.springbootbookcurdoperation.model.Book;
import com.nareshit.springbootbookcurdoperation.repository.BookRepository;
import com.nareshit.springbootbookcurdoperation.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookRequestDto> getAllBook() {
		List<Book> listBooks = bookRepository.findAll();
		List<BookRequestDto> listBookRequestDtos = new ArrayList<>();
		listBooks.forEach(book -> {
			BookRequestDto bookRequestDto = new BookRequestDto();
			bookRequestDto.setBookId(book.getBookId());
			bookRequestDto.setAuthorName(book.getAuthorName());
			bookRequestDto.setBookName(book.getBookName());
			bookRequestDto.setBookPrice(book.getBookPrice());
			listBookRequestDtos.add(bookRequestDto);
		});
		return listBookRequestDtos;
	}

	@Override
	public void saveBook(BookRequestDto bookRequestDto) {
		Book book = new Book();
		book.setAuthorName(bookRequestDto.getAuthorName());
		book.setBookName(bookRequestDto.getBookName());
		book.setBookPrice(bookRequestDto.getBookPrice());
		bookRepository.save(book);
	}

	@Override
	public void updateBook(BookRequestDto bookRequestDto) {
		Book book = new Book();
		book.setBookId(bookRequestDto.getBookId());
		book.setAuthorName(bookRequestDto.getAuthorName());
		book.setBookName(bookRequestDto.getBookName());
		book.setBookPrice(bookRequestDto.getBookPrice());
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long bookId) {
		if (bookId != null) {
			bookRepository.deleteById(bookId);
		}
	}

	@Override
	public void updateBookByAuthor(String bookName, Long bookId) {
		Book book = new Book();
		book.setBookName(bookName);
		book.setBookId(bookId);
		bookRepository.save(book);
	}

	@Override
	public Optional<Book> getBookById(Long bookId) {
		return bookRepository.findById(bookId);
	}

}
