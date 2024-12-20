package com.mservices.orderservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Service API")
                        .version("1.0")
                        .description("API documentation for Order Service")
                        .contact(new Contact()
                                .name("Aakash Chaturvedi")
                                .email("aakash@example.com")
                                .url("https://example.com")
                        )
                );
    }
}
