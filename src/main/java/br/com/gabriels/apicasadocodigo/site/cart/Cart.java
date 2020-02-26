package br.com.gabriels.apicasadocodigo.site.cart;

import br.com.gabriels.apicasadocodigo.books.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    private List<BookCartDto> books = new ArrayList<>();

    public void add(Book book) {
        books.add(new BookCartDto(book));
    }

    public List<BookCartDto> getBooks() {
        return books;
    }

    public static Cart build(Optional<String> cartJson) {
        return cartJson.map(json -> {
            try {
                return new ObjectMapper().readValue(json, Cart.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).orElse(new Cart());
    }
}
