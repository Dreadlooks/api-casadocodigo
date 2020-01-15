package br.com.gabriels.apicasadocodigo.books;

import br.com.gabriels.apicasadocodigo.shared.validator.UniqueFieldValidator;

import java.util.Optional;

public class UniqueBookIsbnValidador extends UniqueFieldValidator<NewBookForm> {

    private BookRepository bookRepository;

    public UniqueBookIsbnValidador(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional getFieldToSearch(NewBookForm bookForm) {
        return bookRepository.findByIsbn(bookForm.getIsbn());
    }

    @Override
    public String getInvalidField() {
        return "isbn";
    }
}
