package br.com.gabriels.apicasadocodigo.site.detail;

import br.com.gabriels.apicasadocodigo.books.Book;
import br.com.gabriels.apicasadocodigo.books.BookRepository;
import br.com.gabriels.apicasadocodigo.shared.Cookies;
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

    @Autowired
    private Cookies cookies;

    @GetMapping("/{id}")
    public BookDetailDto detail(@PathVariable("id") Long id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        return new BookDetailDto(book);
    }

    @PostMapping("/cart/{id}")
    public Cart addBookToCart(@PathVariable("id") Long id, @CookieValue("cart") Optional<String> cartJson,
                              HttpServletResponse response) {

        Cart cart = Cart.build(cartJson);
        cart.add(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException()));

        cookies.writeAsJson("cart", cart, response);
        return cart;
    }
}
