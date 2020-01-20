package br.com.gabriels.apicasadocodigo.site.detail;

import br.com.gabriels.apicasadocodigo.books.Book;

import java.math.BigDecimal;

public class BookDetailDto {

    private Long id;
    private String isbn;
    private String title;
    private String subtitle;
    private BigDecimal price;
    private String content;
    private String summary;
    private AuthorBookDetailDto author;
    private int numberOfPages;


    public BookDetailDto(Book book) {
        this.id = book.getId();
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.subtitle = book.getSubtitle();
        this.price = book.getPrice();
        this.content =  book.getContent();
        this.summary = book.getSummary();
        this.author = new AuthorBookDetailDto(book.getAuthor());
        this.numberOfPages = book.getNumberOfPages();
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
    }

    public AuthorBookDetailDto getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
