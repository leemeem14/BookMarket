package kr.ac.kopo.lyh.bookmarket.domain;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;


@Data
//@Getter
//@Setter
//@NoArgsConstructor
public class Book {
    @Pattern(regexp = "isbn[0-9]+")
    private String bookID; //도서번호
    @Size(min = 4, max = 50)
    private String name; //도서명
    @Min(value=0)
    @Digits(integer=8, fraction=2)
    @NotNull
    private BigDecimal unitPrice; //단가
    private String author; //작가
    private String description; //설명
    private String publisher; //출판사
    private String category; //장르
    private long unitsInStock; //재고량
    private String releaseDate; //출판일
    private String condition; //책상태
    private String fileName; //이미지이름
    private MultipartFile bookImage; //업로드된 도서 이미지
}
