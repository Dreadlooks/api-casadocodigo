package br.com.gabriels.apicasadocodigo.site.cart;

import br.com.gabriels.apicasadocodigo.books.Book;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<BookCartDto> cart = new ArrayList<>();

    public void add(Book book) {
        cart.add(new BookCartDto(book));
    }

    public List<BookCartDto> getCart() {
        return cart;
    }
}
