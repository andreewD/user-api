package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRQ {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}
