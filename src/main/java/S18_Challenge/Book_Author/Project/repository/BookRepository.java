package S18_Challenge.Book_Author.Project.repository;

import S18_Challenge.Book_Author.Project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
