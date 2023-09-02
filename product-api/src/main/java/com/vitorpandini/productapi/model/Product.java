package com.vitorpandini.productapi.model;


import com.vitorpandini.productapi.dto.ProductDTO;
import jakarta.persistence.*;

@Entity(name = "product")
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String nome, Float preco, String descricao, String productIdentifier, Category category) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.productIdentifier = productIdentifier;
        this.category = category;
    }


    public static Product convert(ProductDTO productDTO){
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setPreco(productDTO.getPreco());
        product.setProductIdentifier(productDTO.getProductIdentifier());
        if (productDTO.getCategoryDTO()!= null) {
            product.setCategory(Category.convert(productDTO.getCategoryDTO()));
        }
        return product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }
}
