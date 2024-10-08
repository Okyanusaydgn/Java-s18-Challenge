package S18_Challenge.Book_Author.Project.service;

import S18_Challenge.Book_Author.Project.entity.Book;

import java.util.List;

public interface BookService {

    Book findById(Long id);
    Book save(Book book);

    Book update(Long id, Book book);

    void delete(Long id);

    List<Book>findAll();


}
