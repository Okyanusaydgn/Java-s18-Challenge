package S18_Challenge.Book_Author.Project.service;

import S18_Challenge.Book_Author.Project.entity.Book;
import S18_Challenge.Book_Author.Project.exception.BookNotFoundException;
import S18_Challenge.Book_Author.Project.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public Book findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            return bookOptional.get();
        }
        throw new BookNotFoundException("Book with id "+ id +" is not found");
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }


    @Override
    public Book update(Long id, Book book){
        if (!bookRepository.existsById(id)){
            throw new BookNotFoundException("Book with id"+ id+ "is not found");
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id){
        if (!bookRepository.existsById(id)){
            throw new BookNotFoundException("Book with id"+id+"is not found");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
