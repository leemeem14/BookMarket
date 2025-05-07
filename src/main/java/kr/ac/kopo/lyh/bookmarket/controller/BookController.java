package kr.ac.kopo.lyh.bookmarket.controller;

import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.lyh.bookmarket.domain.Book;
import kr.ac.kopo.lyh.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Value("${file.uploadDir}")
    String fileDir;


    @GetMapping
    public String requestBookList(Model model) {
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList", bookList);
        return "Books";
    }

    @GetMapping("/all")
    public ModelAndView requestAllBookList() {
        ModelAndView modelV = new ModelAndView();
        modelV.setViewName("Book");
        List<Book> bookList = bookService.getAllBookList();
        modelV.addObject("bookList", bookList);
        return modelV ;
    }
    @GetMapping("/book")
    public String requestBookById(@RequestParam("id")String bookId, Model model) {
        Book bookById = bookService.getBookById(bookId);
        model.addAttribute("book", bookById);
        return "Book";
    }
    @GetMapping("/{category}")
    public String requestBookByCategory(@PathVariable("category") String category, Model model) {
        List<Book> booksByCategory = bookService.getBookByCategory(category);
        model.addAttribute("bookList", booksByCategory);
        return "Books";
    }
    @GetMapping("/filter/{bookFilter}")
    public String requestBookListByFilter(@MatrixVariable(pathVar = "bookFilter")Map<String, List<String>> bookFilter, Model model) {
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "Books";
    }
    @GetMapping("/add")
    public String requestAddBookForm() {
        return "addBook";
    }

    @PostMapping("/add")
    public String requestAddBook(@ModelAttribute Book book) {
        MultipartFile bookImage = book.getBookImage();
        String saveName = bookImage.getOriginalFilename();
        File saveFile = new File(fileDir + saveName);
        if(bookImage != null && !bookImage.isEmpty()){
            try{
                bookImage.transferTo(saveFile);
            } catch(Exception e){
                throw new RuntimeException("도서 이미지 업로드 실패함",e);
            }
        }
        book.setFileName(saveName);
        bookService.setNewBook(book);
        return "redirect:/books";
    }
    @GetMapping("/download")
    public void downloadBookImage(@RequestParam("file")String paramKey, HttpServletResponse response) throws IOException {
        File imageFile = new File(fileDir + paramKey);
        response.setContentType("application/download");
        response.setContentLength((int)imageFile.length());
        response.setHeader("Content-Disposition","attachment; filename=\"" + paramKey + "\"");
        OutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(imageFile);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();
    }
    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("addTitle", "신규도서 등록");
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields("bookId", "name","unitPrice", "author", "description", "publisher", "category", "unitsInStock","releaseDate","condition","bookImage");
    }
}
