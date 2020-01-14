package br.com.gabriels.apicasadocodigo.categories;

import br.com.gabriels.apicasadocodigo.shared.validator.UniqueFieldValidator;

import java.util.Optional;

public class UniqueCategoryNameValidator extends UniqueFieldValidator {

    private CategoryRepository categoryRepository;

    public UniqueCategoryNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<?> getFieldToSearch(Object object) {
        NewCategoryForm categoryForm = (NewCategoryForm) object;
        return categoryRepository.findByName(categoryForm.getName());
    }

    @Override
    public String getInvalidField() {
        return "name";
    }
}
