package com.vitorpandini.shoppingapi.model;

import com.vitorpandini.shoppingapi.dto.ShopDTO;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "shop")
@Table(name = "tb_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userIdentifier;
    private float total;
    private Date date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item",joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> itens;

    public Shop() {
    }

    public Shop(String userIdentifier, float total, Date date, List<Item> itens) {
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.date = date;
        this.itens = itens;
    }

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setTotal(shopDTO.getTotal());
        shop.setDate(shopDTO.getDate());
        shop.setItens(shopDTO.getItens().stream().map(Item::convert).collect(Collectors.toList()));
        return shop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
