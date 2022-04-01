package com.nareshit.springbootbookcurdoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.springbootbookcurdoperation.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
 
	 
}
