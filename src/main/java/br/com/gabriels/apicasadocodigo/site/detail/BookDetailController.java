package br.com.gabriels.apicasadocodigo.site.detail;

import br.com.gabriels.apicasadocodigo.books.Book;
import br.com.gabriels.apicasadocodigo.books.BookRepository;
import br.com.gabriels.apicasadocodigo.shared.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/site/book-detail")
public class BookDetailController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    public BookDetailDto detail(@PathVariable("id") Long id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        return new BookDetailDto(book);
    }
}
