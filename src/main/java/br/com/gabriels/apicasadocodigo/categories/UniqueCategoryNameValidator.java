package br.com.gabriels.apicasadocodigo.categories;

import br.com.gabriels.apicasadocodigo.shared.validator.UniqueFieldValidator;

import java.util.Optional;

public class UniqueCategoryNameValidator extends UniqueFieldValidator<NewCategoryForm> {

    private CategoryRepository categoryRepository;

    public UniqueCategoryNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional getFieldToSearch(NewCategoryForm categoryForm) {
        return categoryRepository.findByName(categoryForm.getName());
    }

    @Override
    public String getInvalidField() {
        return "name";
    }
}
