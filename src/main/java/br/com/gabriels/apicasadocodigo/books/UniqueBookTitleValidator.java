package br.com.gabriels.apicasadocodigo.books;

import br.com.gabriels.apicasadocodigo.shared.validator.UniqueFieldValidator;

import java.util.Optional;

public class UniqueBookTitleValidator extends UniqueFieldValidator {

    private BookRepository bookRepository;

    public UniqueBookTitleValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<?> getFieldToSearch(Object object) {
        NewBookForm bookForm = (NewBookForm) object;
        return bookRepository.findByTitle(bookForm.getTitle());
    }

    @Override
    public String getInvalidField() {
        return "title";
    }
}
