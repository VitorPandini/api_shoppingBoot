package com.vitorpandini.productapi.dto;

import com.vitorpandini.productapi.model.Category;

public class CategoryDTO {

    private Long id;
    private String nome;

    public CategoryDTO(String nome) {
        this.nome = nome;
    }

    public CategoryDTO() {
    }

    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryDTO.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
