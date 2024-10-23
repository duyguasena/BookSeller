package com.example.BookSeller.repository;

import com.example.BookSeller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {

}
