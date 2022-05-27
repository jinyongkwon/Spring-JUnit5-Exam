package site.metacoding.blogv4junit.domain.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

// 클라이언트한테 받아서 데이터를 넣을때만 set함. DB에서 가져와서 데이터를 넣으면 set하지 않음.
@Getter
@Entity
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String author;

    @Builder
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
