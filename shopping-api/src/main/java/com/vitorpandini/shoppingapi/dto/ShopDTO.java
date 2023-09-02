package com.vitorpandini.shoppingapi.dto;

import com.vitorpandini.shoppingapi.model.Item;
import com.vitorpandini.shoppingapi.model.Shop;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.Date;
import java.util.List;

public class ShopDTO {


    @NotBlank
    private String userIdentifier;
    @NotNull
    private float total;
    @NotNull
    private Date date;
    @NotNull
    private List<Item> itens;

    public ShopDTO() {
    }

    public ShopDTO(String userIdentifier, @NotNull float total, @NotNull Date date, @NotNull List<Item> itens) {
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.date = date;
        this.itens = itens;
    }

    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
