package com.vitorpandini.productapi.service;

import com.vitorpandini.productapi.dto.ProductDTO;
import com.vitorpandini.productapi.model.Product;
import com.vitorpandini.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> getAll(){
        return repository.findAll().stream().map(ProductDTO::convert).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId){
        return repository.getProductsByCategory(categoryId).stream().map(ProductDTO::convert).collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier){
        var product =repository.findByProductIdentifier(productIdentifier);
        if (product != null){
            return ProductDTO.convert(product);
        }
        return null;
    }

    public ProductDTO save(ProductDTO productDTO){
        var product=repository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

    public void delete(Long productId){
        var product=repository.findById(productId);
        product.ifPresent(value -> repository.delete(value));

    }
}
