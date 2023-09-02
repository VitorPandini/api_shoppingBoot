package com.vitorpandini.userapi.service;

import com.vitorpandini.userapi.dto.UserDTO;
import com.vitorpandini.userapi.model.User;
import com.vitorpandini.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<UserDTO> getAll(){
        return repository.findAll().stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    public UserDTO findById(Long userId){
        var user= repository.findById(userId);
        return user.map(UserDTO::convert).orElse(null);
    }
    public UserDTO save(UserDTO dto){
        var user = repository.save(User.convert(dto));
        return UserDTO.convert(user);
    }

    public UserDTO findByCpf(String cpf){
        var user=repository.findByCpf(cpf);
        if (user != null){
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name){
        var users=repository.queryByNomeLike(name);
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
