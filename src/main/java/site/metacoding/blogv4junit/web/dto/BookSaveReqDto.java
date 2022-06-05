package site.metacoding.blogv4junit.web.dto;

import site.metacoding.blogv4junit.domain.book.Book;

// ReqDto의 경우는 무조건 빈생성자 + Setter가 있어야함.
public class BookSaveReqDto {
    private String title;
    private String author;

    public Book toEntity() {
        return Book.builder().title(this.title).author(this.author).build();
    }

    public BookSaveReqDto(String title, String author) {
        System.out.println("======================================");
        System.out.println("BookSaveReqDto(풀생성자)호출됨.");
        System.out.println("======================================");
        this.title = title;
        this.author = author;
    }

    public BookSaveReqDto() {
        System.out.println("======================================");
        System.out.println("BookSaveReqDto(빈생성자)호출됨.");
        System.out.println("======================================");
    }

    public void setTitle(String title) {
        System.out.println("======================================");
        System.out.println("setTitle()호출됨.");
        System.out.println("======================================");
        this.title = title;
    }

    public void setAuthor(String author) {
        System.out.println("======================================");
        System.out.println("setAuthor()호출됨.");
        System.out.println("======================================");
        this.author = author;
    }
}
