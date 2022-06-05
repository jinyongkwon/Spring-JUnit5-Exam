package site.metacoding.blogv4junit.domain.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // DB와 관련된 컴포넌트만 메모리에 로딩 => h2동작, 자동롤백
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EntityManager em;

    @BeforeEach
    public void db_init() {
        bookRepository.deleteAll();
        em
                .createNativeQuery("ALTER TABLE book ALTER COLUMN id RESTART WITH 1")
                .executeUpdate();
    }

    // C : 유효성 검사 필요 (X)
    @Test
    @Order(1)
    public void save_test() {
        // given
        String title = "스프링부트 1강";
        String author = "권진용";
        Book book = Book.builder().title(title).author(author).build();

        // when
        Book bookEntity = bookRepository.save(book);

        // then
        assertEquals(title, bookEntity.getTitle());
        assertEquals(author, bookEntity.getAuthor());
        assertEquals(1, bookEntity.getId());
    }

    @Test
    @Order(2)
    public void findById_test() {
        // given
        String title = "스프링부트1강";
        String author = "권진용";
        Book book = Book.builder().title(title).author(author).build();
        bookRepository.save(book);

        Long id = 1L;
        // when
        Book bookEntity = bookRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("터짐");
        });

        // then
        assertEquals(title, bookEntity.getTitle());
        assertEquals(author, bookEntity.getAuthor());
        assertEquals(1, bookEntity.getId());
    }
}
