package br.com.gabriels.apicasadocodigo.books;

import br.com.gabriels.apicasadocodigo.authors.Author;
import br.com.gabriels.apicasadocodigo.authors.AuthorRepository;
import br.com.gabriels.apicasadocodigo.shared.fileupload.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private FileStorage fileStorage;

    public Book convert(NewBookForm form) {
        Author author = authorRepository.findById(form.getAuthorId()).get();
        String linkToCover = fileStorage.upload(form.getCover());

        return new Book(form.getTitle(), form.getSubtitle(), form.getPrice(), form.getContent(), form.getSummary(),
                form.getNumberOfPages(), form.getIsbn(), linkToCover, author);
    }
}
