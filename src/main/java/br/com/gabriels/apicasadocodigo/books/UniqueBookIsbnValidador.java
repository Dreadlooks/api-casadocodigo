package br.com.gabriels.apicasadocodigo.books;

import br.com.gabriels.apicasadocodigo.shared.validator.UniqueFieldValidator;

import java.util.Optional;

public class UniqueBookIsbnValidador extends UniqueFieldValidator {

    private BookRepository bookRepository;

    public UniqueBookIsbnValidador(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<?> getFieldToSearch(Object object) {
        NewBookForm newBookForm = (NewBookForm) object;
        return bookRepository.findByIsbn(newBookForm.getIsbn());
    }

    @Override
    public String getInvalidField() {
        return "isbn";
    }
}
