package br.com.gabriels.apicasadocodigo.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public void save(@Valid NewCategoryForm form) {
        Category category = new Category(form.getName());
        categoryRepository.save(category);
    }

    @InitBinder("newCategoryForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new UniqueCategoryNameValidator(categoryRepository));
    }
}
