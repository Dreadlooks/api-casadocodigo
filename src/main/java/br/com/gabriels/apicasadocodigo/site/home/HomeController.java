package br.com.gabriels.apicasadocodigo.site.home;

import br.com.gabriels.apicasadocodigo.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/site/home")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<BookHomeDetailDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookHomeDetailDto::new).collect(Collectors.toList());
    }
}
