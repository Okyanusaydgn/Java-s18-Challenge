package S18_Challenge.Book_Author.Project.controller;

import S18_Challenge.Book_Author.Project.dto.AuthorResponse;
import S18_Challenge.Book_Author.Project.dto.AuthorResponseWithBooks;
import S18_Challenge.Book_Author.Project.dto.BookResponse;
import S18_Challenge.Book_Author.Project.entity.Author;
import S18_Challenge.Book_Author.Project.entity.Book;
import S18_Challenge.Book_Author.Project.service.AuthorService;
import S18_Challenge.Book_Author.Project.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    private final BookService bookService;


    // istemci requestbody ile birlikte Author nesnesi JSON formatında gönderir. Bu nesne de authorService.save(author) sayesinde veritabanına kaydedilir ve geri döndürülür.
    // requestbody içindeki veri örneği aşağıdaki gibidir;
    /*
    * Body:{
    * "firstName": "okyanus",
    * "lastName": "aydogan"
    * }
    *
    * */
    @PostMapping
    public ResponseEntity<AuthorResponse> save(@RequestBody Author author) {
        Author savedAuthor = authorService.save(author);
        AuthorResponse response = new AuthorResponse(savedAuthor.getId(), savedAuthor.getFirstName()+" "+savedAuthor.getLastName());
        return ResponseEntity.ok(response);
    }




    // bir yazara kitap eklemek için aşağıdaki post yapısını kullanıyoruz.

    @PostMapping("/{bookId}")
    public ResponseEntity<AuthorResponseWithBooks> addBookToAuthor(@RequestBody Author author, @PathVariable long bookId){
        Book foundBook = bookService.findById(bookId);

        author.addBook(foundBook);

        Author savedAuthor = authorService.save(author);

        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book authorBook : savedAuthor.getBooks()){
            BookResponse bookResponse = new BookResponse(
                    authorBook.getId(),
                    author.getFirstName(),
                    authorBook.getCategory().getName(),
                    new AuthorResponse(savedAuthor.getId(), savedAuthor.getFirstName()+" "+savedAuthor.getLastName()));
            bookResponses.add(bookResponse);
        }

        AuthorResponseWithBooks responseWithBooks = new AuthorResponseWithBooks(bookResponses);
        return ResponseEntity.ok(responseWithBooks);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> findAuthorById(@PathVariable Long id){
        Author foundAuthor = authorService.findById(id);
        AuthorResponse response = new AuthorResponse(foundAuthor.getId(), foundAuthor.getFirstName()+" "+foundAuthor.getLastName());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> findAllAuthors(){
        List<AuthorResponse> authorResponses = new ArrayList<>();
        for (Author author : authorService.findAll()){
            AuthorResponse response = new AuthorResponse(author.getId(), author.getFirstName()+" "+author.getLastName());
            authorResponses.add(response);
        }
        return ResponseEntity.ok(authorResponses);
    }


}
