package S18_Challenge.Book_Author.Project.service;

import S18_Challenge.Book_Author.Project.entity.Author;
import S18_Challenge.Book_Author.Project.exception.AuthorNotFoundException;
import S18_Challenge.Book_Author.Project.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author findById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }
        throw new AuthorNotFoundException("Author with given id" + id +"is not found");
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author){
        if (!authorRepository.existsById(id)){
            throw new AuthorNotFoundException("Author with id"+id+"is not found");
        }
        author.setId(id);
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException("Author with id " + id + " is not found");
        }
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
