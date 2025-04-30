package kr.ac.kopo.lyh.bookmarket.repository;

import kr.ac.kopo.lyh.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        book1.setBookID("isbn0001");
        book1.setName("스프링부트 완전정복");
        book1.setUnitPrice(BigDecimal.valueOf(35000));
        book1.setAuthor("송미영");
        book1.setDescription("스프링 부트는 스프링을 기반으로 쉽고 빠르게 웹 애플리케이션을 개발할 수 있는 도구이다. " +
                "이 책에서는 스프링 부트의 기본 개념을 쉽게 이해하고 다양한 실습 예제로 빠르게 익힐 수 있다.\n");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT교재");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2024-12-31");
        book1.setCondition("신규도서");

        Book book2 = new Book();
        book2.setBookID("isbn0002");
        book2.setName("앨리스 죽이기");
        book2.setUnitPrice(BigDecimal.valueOf(12150));
        book2.setAuthor("고바야시 야스미");
        book2.setDescription("《이상한 나라의 앨리스》가 가진 환상성에 그로테스크한 묘사와 치밀한 논리가 더해진 본격 미스터리 화제작");
        book2.setPublisher("검은숲");
        book2.setCategory("일본소설");
        book2.setUnitsInStock(1000);
        book2.setReleaseDate("2015-12-21");
        book2.setCondition("신규도서");
        Book book3 = new Book();
        book3.setBookID("isbn0003");
        book3.setName("도로시 죽이기");
        book3.setUnitPrice(BigDecimal.valueOf(12150));
        book3.setAuthor("고바야시 야스미");
        book3.setDescription("베스트셀러 『앨리스 죽이기』의 후속작" +
                "『도로시 죽이기』 한일 동시 출간!\n");
        book3.setPublisher("검은숲");
        book3.setCategory("일본소설");
        book3.setUnitsInStock(1000);
        book3.setReleaseDate("2018-05-18");
        book3.setCondition("신규도서");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {return listOfBooks;}

    @Override
    public Book getBookById(String bookId) {
        Book bookInfo = null;
        for (Book book : listOfBooks) {
            if (book!= null && book.getBookID()!=null && book.getBookID().equals(bookId)) {
                bookInfo = book;
                break;
            }
        }

        if(bookInfo == null){
            throw new IllegalArgumentException("도서번호가"+ bookId+"인 해당도서를 찾을수 없다.");
        }
        return bookInfo;
    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<Book>();
        for(int i =0; i<listOfBooks.size(); i++ ){
            Book book = listOfBooks.get(i);
            if(book.getCategory().equals(category)){
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if(booksByFilter.contains("publisher")){
            for(int i = 0; i<filter.get("publisher").size(); i++){
                String publisherName = filter.get("publisher").get(i);
                for (Book book : listOfBooks) {
                    if(book.getPublisher().equals(publisherName)){
                        booksByPublisher.add(book);
                    }
                }
            }
        }
        if(booksByFilter.contains("category")){
            for(int i = 0; i<filter.get("category").size(); i++){
                String categoryName = filter.get("category").get(i);
                List<Book> list = getBookByCategory(categoryName);
                booksByCategory.addAll(list);
                }
            }
        //저장된 요소중에서 2 set(booksbycategory,booksbypublisher) 를 비교하여 같은 값만 남기고 제거하는 역할(교집합)
        booksByCategory.retainAll(booksByPublisher);

        return Set.of();
    }
}
