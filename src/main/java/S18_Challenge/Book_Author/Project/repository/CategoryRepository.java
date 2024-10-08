package S18_Challenge.Book_Author.Project.repository;

import S18_Challenge.Book_Author.Project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
