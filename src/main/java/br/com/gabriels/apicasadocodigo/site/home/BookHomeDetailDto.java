package br.com.gabriels.apicasadocodigo.site.home;

import br.com.gabriels.apicasadocodigo.books.Book;

public class BookHomeDetailDto {

    private Long id;
    private String title;
    private String authorsName;

    public BookHomeDetailDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorsName = book.getAuthor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorsName() {
        return authorsName;
    }
}
