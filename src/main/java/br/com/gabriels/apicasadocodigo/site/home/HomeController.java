package br.com.gabriels.apicasadocodigo.site.home;

import br.com.gabriels.apicasadocodigo.books.Book;
import br.com.gabriels.apicasadocodigo.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/site/home")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
