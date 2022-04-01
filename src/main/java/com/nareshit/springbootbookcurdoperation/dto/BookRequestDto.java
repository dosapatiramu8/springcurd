package com.nareshit.springbootbookcurdoperation.dto;

public class BookRequestDto {
	private Long bookId;
	private String authorName;
	private String bookName;
	private Double bookPrice;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "BookRequestDto [bookId=" + bookId + ", authorName=" + authorName + ", bookName=" + bookName
				+ ", bookPrice=" + bookPrice + "]";
	}

}
