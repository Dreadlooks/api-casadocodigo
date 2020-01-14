package br.com.gabriels.apicasadocodigo.books;

import br.com.gabriels.apicasadocodigo.authors.Author;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Size(max = 50)
    private String subtitle;

    @Min(5)
    private BigDecimal price = BigDecimal.ZERO;

    @NotBlank
    private String content;

    @NotBlank
    private String summary;

    @Min(50)
    private int numberOfPages;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @NotNull
    private String linkToCover;

    @NotNull
    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {}


    public Book(@NotBlank @Size(max = 100) String title, @NotBlank @Size(max = 50) String subtitle, @Min(5) BigDecimal price,
                @NotBlank String  content, @NotBlank String summary, @Min(50) int numberOfPages, @NotBlank String isbn,
                @NotNull String linkToCover, @NotNull Author author) {

        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
        this.content = content;
        this.summary = summary;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.linkToCover = linkToCover;
        this.author = author;
    }
}
