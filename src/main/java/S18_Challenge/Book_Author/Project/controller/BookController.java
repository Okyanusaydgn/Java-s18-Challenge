package S18_Challenge.Book_Author.Project.controller;

import S18_Challenge.Book_Author.Project.dto.AuthorResponse;
import S18_Challenge.Book_Author.Project.dto.BookResponse;
import S18_Challenge.Book_Author.Project.entity.Author;
import S18_Challenge.Book_Author.Project.entity.Book;
import S18_Challenge.Book_Author.Project.entity.Category;
import S18_Challenge.Book_Author.Project.service.AuthorService;
import S18_Challenge.Book_Author.Project.service.BookService;
import S18_Challenge.Book_Author.Project.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @PostMapping("/{categoryId}")
    public ResponseEntity<BookResponse> saveBookWithCategory(@RequestBody Book book, @PathVariable long categoryId){
        Category category = categoryService.findById(categoryId);
        book.setCategory(category); // kategory'i bul ve kitap ile ilişkilendir.
        category.addBook(book);


        //kitabı kaydet
        bookService.save(book);

        BookResponse response = new BookResponse(book.getId(), book.getName(), category.getName(), null);
        return ResponseEntity.ok(response);
    }

    // Kitabı hem kategori hem de yazar bilgisi ile kaydeden endpoint
    @PostMapping("/saveByAuthor")
    public ResponseEntity<BookResponse> saveBookWithAuthorAndCategory(@RequestBody Book book,@RequestParam long categoryId,@RequestParam long authorId){
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);

        Author author = authorService.findById(authorId);
        book.setAuthor(author);
        author.addBook(book);

        BookResponse response = new BookResponse(
                book.getId(),
                book.getName(),
                category.getName(),
                new AuthorResponse(author.getId(), author.getFirstName()+" "+author.getLastName())
        );

        return ResponseEntity.ok(response);
    }

}
