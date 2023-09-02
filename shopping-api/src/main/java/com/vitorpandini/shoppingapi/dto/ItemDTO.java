package com.vitorpandini.shoppingapi.dto;

import com.vitorpandini.shoppingapi.model.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemDTO {
    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public ItemDTO(String productIdentifier,Float price) {
        this.productIdentifier = productIdentifier;
        this.price = price;
    }

    public ItemDTO() {
    }

    public static ItemDTO convert(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
