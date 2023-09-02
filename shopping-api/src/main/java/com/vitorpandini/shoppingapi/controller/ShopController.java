package com.vitorpandini.shoppingapi.controller;

import com.vitorpandini.shoppingapi.dto.ShopDTO;
import com.vitorpandini.shoppingapi.service.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService service;

    @GetMapping("/all")
    public List<ShopDTO> getShops(){
        return service.getAll();
    }

    @GetMapping("/byUser/{userIdentifier}")
    public List<ShopDTO> getShopsByUser(@PathVariable String userIdentifier){
        return service.getByUser(userIdentifier);
    }

    @GetMapping("/byDate")
    public List<ShopDTO> getByDate(@RequestBody ShopDTO shopDTO){
        return service.getByDate(shopDTO);
    }
    @GetMapping("byId/{id}")
    public ShopDTO findById(@PathVariable Long id){
        return service.findById(id);
    }


    @PostMapping
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO){
        return service.save(shopDTO);
    }


}
