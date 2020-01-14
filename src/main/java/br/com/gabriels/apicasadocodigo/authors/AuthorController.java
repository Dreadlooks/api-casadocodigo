package br.com.gabriels.apicasadocodigo.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    public void save(@Valid NewAuthorForm form) {
        Author author = form.toModel();
        authorRepository.save(author);
    }
}
