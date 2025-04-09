package kr.ac.kopo.lyh.bookmarket.repository;

import kr.ac.kopo.lyh.bookmarket.domain.Book;

import java.util.List;

import java.util.Map;

import java.util.Set;

import com.springboot.domain.Book;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
}
