package br.com.gabriels.apicasadocodigo.books;

import br.com.gabriels.apicasadocodigo.shared.validator.UniqueFieldValidator;

import java.util.Optional;

public class UniqueBookTitleValidator extends UniqueFieldValidator<NewBookForm> {

    private BookRepository bookRepository;

    public UniqueBookTitleValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional getFieldToSearch(NewBookForm bookForm) {
        return bookRepository.findByTitle(bookForm.getTitle());
    }

    @Override
    public String getInvalidField() {
        return "title";
    }
}
