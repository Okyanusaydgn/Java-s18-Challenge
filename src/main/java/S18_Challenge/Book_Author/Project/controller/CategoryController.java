package S18_Challenge.Book_Author.Project.controller;

import S18_Challenge.Book_Author.Project.dto.CategoryResponse;
import S18_Challenge.Book_Author.Project.entity.Book;
import S18_Challenge.Book_Author.Project.entity.Category;
import S18_Challenge.Book_Author.Project.service.BookService;
import S18_Challenge.Book_Author.Project.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@RequestBody Category category){
        Category savedCategory = categoryService.save(category);
        CategoryResponse response = new CategoryResponse(savedCategory.getId(), savedCategory.getName());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<CategoryResponse> addBookToCategory(@PathVariable long bookId, @RequestParam long categoryId){
        Book foundBook = bookService.findById(bookId);
        Category foundCategory = categoryService.findById(categoryId);

        foundCategory.addBook(foundBook); // Kitap kategoriye eklenir
        foundBook.setCategory(foundCategory);  // Kitap kategorisi güncellenir
        categoryService.save(foundCategory); // Kategori güncellenir

        CategoryResponse response = new CategoryResponse(foundCategory.getId(), foundCategory.getName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable long id){
        Category foundCategory = categoryService.findById(id);
        CategoryResponse response = new CategoryResponse(foundCategory.getId(), foundCategory.getName());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategories(){
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categoryService.findAll()){
            CategoryResponse response = new CategoryResponse(category.getId(), category.getName());
            categoryResponses.add(response);
        }

        return ResponseEntity.ok(categoryResponses);
    }


}
