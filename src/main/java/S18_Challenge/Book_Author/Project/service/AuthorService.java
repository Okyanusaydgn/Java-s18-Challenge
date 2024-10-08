package S18_Challenge.Book_Author.Project.service;

import S18_Challenge.Book_Author.Project.entity.Author;

import java.util.List;

public interface AuthorService {
    Author findById(Long id);

    Author save(Author author);
    Author update(Long id, Author author);
    void delete(Long id);
    List<Author> findAll();
}
