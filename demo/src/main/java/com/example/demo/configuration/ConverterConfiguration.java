package com.example.demo.configuration;

import com.example.demo.controller.UserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfiguration {
    @Bean
    public UserConverter converter() {
        return new UserConverter();
    }

}
