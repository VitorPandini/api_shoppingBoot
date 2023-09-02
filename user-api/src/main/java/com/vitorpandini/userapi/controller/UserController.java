package com.vitorpandini.userapi.controller;

import com.vitorpandini.userapi.dto.UserDTO;
import com.vitorpandini.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return service.getAll();
    }

    @GetMapping("/searchId/{id}")
    public UserDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
    @GetMapping("/searchCpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf){
        return service.findByCpf(cpf);
    }

    @GetMapping("/user/search")
    public List<UserDTO> searchByName(@RequestParam(name = "nome")String nome){
        return service.queryByName(nome);
    }

    @PostMapping("/create")
    public UserDTO newUser(@RequestBody UserDTO userDTO){
        return service.save(userDTO);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
