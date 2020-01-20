package br.com.gabriels.apicasadocodigo.site.detail;

import br.com.gabriels.apicasadocodigo.authors.Author;

public class AuthorBookDetailDto {

    private String name;
    private String description;
    private String linkToGithub;

    public AuthorBookDetailDto(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
        this.linkToGithub = author.getLinkGithub();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkToGithub() {
        return linkToGithub;
    }
}
