package com.example.demo.controller;

import com.example.demo.dtos.UserDTO;
import com.example.demo.dtos.UserSearchDTO;
import com.example.demo.models.Client;

public class UserConverter {
    public Client convert(UserDTO dto){
        if (dto == null) {
            return null;
        }

        return Client.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .age(dto.getAge())
                .build();
    }

    public UserDTO convertUser(Client user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }
    public UserSearchDTO convert(Client user){
        if (user == null) {
            return null;
        }
        return UserSearchDTO.builder()
                .user(convertUser(user))
                .build();
    }
}
