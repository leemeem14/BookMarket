package kr.ac.kopo.lyh.bookmarket.service;

import kr.ac.kopo.lyh.bookmarket.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookByCategory(String category);
}
