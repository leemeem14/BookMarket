package kr.ac.kopo.lyh.bookmarket.repository;

import kr.ac.kopo.lyh.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
}
