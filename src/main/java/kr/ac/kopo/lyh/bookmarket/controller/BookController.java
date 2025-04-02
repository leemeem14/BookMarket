package kr.ac.kopo.lyh.bookmarket.controller;

import kr.ac.kopo.lyh.bookmarket.domain.Book;
import kr.ac.kopo.lyh.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestBookList(Model model) {
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList", bookList);
        return "Books";
    }

    @GetMapping("/all")
    public ModelAndView requestAllBookList() {
        ModelAndView modelV = new ModelAndView();
        modelV.setViewName("Books");
        List<Book> bookList = bookService.getAllBookList();
        modelV.addObject("bookList", bookList);
        return modelV ;
    }

}
