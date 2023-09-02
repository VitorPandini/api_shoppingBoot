package com.vitorpandini.productapi.controller;

import com.vitorpandini.productapi.dto.ProductDTO;
import com.vitorpandini.productapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public List<ProductDTO> getAll(){
        return service.getAll();
    }
    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId){
        return service.getProductByCategoryId(categoryId);
    }
    @GetMapping("/identifier/{productIdentifier}")
    public ProductDTO findProductByIdentifier(@PathVariable String productIdentifier){
        return service.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/new")
    public ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO){
        return service.save(productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)/*throws ProductNotFoundException*/{
        service.delete(id);
    }

}
