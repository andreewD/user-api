package com.example.demo.service;

import com.example.demo.models.Client;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Client create(Client user){
        return userRepository.save(user);
    }

    public Client update(Client user){
        Client currentUser = findById(user.getId());
        if(Objects.isNull(currentUser)){
            throw new RuntimeException("User not found");
        }
        return userRepository.save(user);
    }

    public boolean delete(Integer id){
        Client user = findById(id);
        if(Objects.isNull(user)){
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    public Client findById(Integer id){
        return userRepository.findById(id).orElse(null);
    }
}
