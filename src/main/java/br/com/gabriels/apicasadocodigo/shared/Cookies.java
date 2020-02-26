package br.com.gabriels.apicasadocodigo.shared;

import br.com.gabriels.apicasadocodigo.site.cart.Cart;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class Cookies {

    public void writeAsJson(String key, Cart cart, HttpServletResponse response) {
        Cookie cookie;
        try {
            cookie = new Cookie(key, new ObjectMapper().writeValueAsString(cart));
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
