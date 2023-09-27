package com.example.demo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Demo")
                        .description("Demo")
                        .version("1.0.0")
                );
    }

}
