package br.com.gabriels.apicasadocodigo.authors;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class NewAuthorForm {

    @NotBlank
    private String name;

    @NotBlank
    @URL
    private String linkGithub;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }

    public Author toModel() {
        return new Author(name, linkGithub);
    }
}
