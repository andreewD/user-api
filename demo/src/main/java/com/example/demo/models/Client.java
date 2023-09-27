package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Integer age;
    private String creationUser;
    private LocalDate creationDate;
    private LocalDate updateDate;
}
