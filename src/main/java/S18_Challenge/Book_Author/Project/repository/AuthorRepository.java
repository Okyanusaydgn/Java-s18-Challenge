package S18_Challenge.Book_Author.Project.repository;

import S18_Challenge.Book_Author.Project.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
