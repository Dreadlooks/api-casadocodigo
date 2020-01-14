package br.com.gabriels.apicasadocodigo.categories;

import javax.validation.constraints.NotBlank;

public class NewCategoryForm {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
