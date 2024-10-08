package S18_Challenge.Book_Author.Project.service;

import S18_Challenge.Book_Author.Project.entity.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    Category save(Category category);

    Category update(Long id, Category category);

    void delete(Long id);

    List<Category> findAll();
}
