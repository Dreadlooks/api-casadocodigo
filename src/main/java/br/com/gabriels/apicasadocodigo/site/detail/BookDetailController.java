package br.com.gabriels.apicasadocodigo.site.detail;

import br.com.gabriels.apicasadocodigo.books.Book;
import br.com.gabriels.apicasadocodigo.books.BookRepository;
import br.com.gabriels.apicasadocodigo.shared.exception.BookNotFoundException;
import br.com.gabriels.apicasadocodigo.site.cart.Cart;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/api/site/book-detail")
public class BookDetailController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    public BookDetailDto detail(@PathVariable("id") Long id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        return new BookDetailDto(book);
    }

    @PostMapping("/cart/{id}")
    public Cart addBookToCart(@PathVariable("id") Long id, @CookieValue("cart") Optional<String> cartJson,
                              HttpServletResponse response) throws JsonProcessingException {

        Cart cart = cartJson.map(json -> {
            try {
                return new ObjectMapper().readValue(json, Cart.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).orElse(new Cart());


        cart.add(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException()));

        Cookie cookie = new Cookie("cart", new ObjectMapper().writeValueAsString(cart));
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return cart;
    }
}
