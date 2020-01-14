package br.com.gabriels.apicasadocodigo.categories;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueCategoryNameValidator implements Validator {

    private CategoryRepository categoryRepository;

    public UniqueCategoryNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewCategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        NewCategoryForm form = (NewCategoryForm) object;
        Optional<Category> possibleCategory = categoryRepository.findByName(form.getName());

        if (possibleCategory.isPresent()) {
            errors.rejectValue("name", null, "Não pode conter nome de categoria repetido!");
        }
    }
}
