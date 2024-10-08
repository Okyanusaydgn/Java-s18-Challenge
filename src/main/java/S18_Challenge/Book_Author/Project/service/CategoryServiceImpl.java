package S18_Challenge.Book_Author.Project.service;

import S18_Challenge.Book_Author.Project.entity.Category;
import S18_Challenge.Book_Author.Project.exception.CategoryNotFoundException;
import S18_Challenge.Book_Author.Project.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private  CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        throw new CategoryNotFoundException("Category with id " + id +" is not found");
    }

    @Override
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category){
        if(!categoryRepository.existsById(id)){
            throw new CategoryNotFoundException("Category with id " + id + "is not found");
        }
        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id){
        if (!categoryRepository.existsById(id)){
            throw new CategoryNotFoundException("Category with id" + id + "is not found");
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
