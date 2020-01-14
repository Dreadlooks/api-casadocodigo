package br.com.gabriels.apicasadocodigo.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookConverter bookConverter;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public void save(@Valid NewBookForm form) {
        Book book = bookConverter.convert(form);
        bookRepository.save(book);
    }
}
