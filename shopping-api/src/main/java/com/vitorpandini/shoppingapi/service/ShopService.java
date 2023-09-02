package com.vitorpandini.shoppingapi.service;

import com.vitorpandini.shoppingapi.dto.ShopDTO;
import com.vitorpandini.shoppingapi.model.Shop;
import com.vitorpandini.shoppingapi.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ShopRepository repository;

    public List<ShopDTO> getAll(){
        return repository.findAll().stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier){
        return repository.findAllByUserIdentifier(userIdentifier).stream().map(ShopDTO::convert).toList();
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO){
        return repository.findAllByDateGreaterThanEqual(shopDTO.getDate()).stream().map(ShopDTO::convert).toList();
    }

    public ShopDTO findById(Long id){
        var shop=repository.findById(id);
        return shop.map(ShopDTO::convert).orElse(null);
    }

    public ShopDTO save(ShopDTO shopDTO){
        shopDTO.setTotal(shopDTO.getItens().stream().map(x ->x.getPrice()).reduce((float)0,Float::sum));

        var shop= Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = repository.save(shop);

        return ShopDTO.convert(shop);

    }


}
