package br.com.gabriels.apicasadocodigo.site.cart;

import br.com.gabriels.apicasadocodigo.books.Book;

import java.math.BigDecimal;

public class BookCartDto {

    private String title;
    private String linkToCover;
    private BigDecimal price = BigDecimal.ZERO;

    @Deprecated
    public BookCartDto() {
    }

    public BookCartDto(Book book) {
        this.title = book.getTitle();
        this.linkToCover = book.getLinkToCover();
        this.price = book.getPrice();
    }

    public String getTitle() {
        return title;
    }

    public String getLinkToCover() {
        return linkToCover;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
