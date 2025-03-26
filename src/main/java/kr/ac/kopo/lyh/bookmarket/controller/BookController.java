package kr.ac.kopo.lyh.bookmarket.controller;

import kr.ac.kopo.lyh.bookmarket.domain.Book;
import kr.ac.kopo.lyh.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books")
    public String requestBookList(Model model) {
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList", bookList);
        return "Books";
    }

}
