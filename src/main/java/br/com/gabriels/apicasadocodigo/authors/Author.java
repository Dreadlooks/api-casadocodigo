package br.com.gabriels.apicasadocodigo.authors;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String linkGithub;

    @PastOrPresent
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Author() {
    }

    public Author(@NotBlank String name, @NotBlank @URL String linkGithub) {
        this.name = name;
        this.linkGithub = linkGithub;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
