package br.com.gabriels.apicasadocodigo.books;

import br.com.gabriels.apicasadocodigo.authors.Author;
import br.com.gabriels.apicasadocodigo.authors.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    @Autowired
    private AuthorRepository authorRepository;

    public Book convert(NewBookForm form) {
        Author author = authorRepository.findById(form.getAuthorId()).get();

        return new Book(form.getTitle(), form.getSubtitle(), form.getPrice(), form.getContent(), form.getSummary(),
                form.getNumberOfPages(), form.getIsbn(), "https://google.com.br", author);
    }
}
