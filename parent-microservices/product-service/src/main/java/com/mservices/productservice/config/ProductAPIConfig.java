package com.mservices.productservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Service API")
                        .version("1.0")
                        .description("API documentation for Product Service")
                        .contact(new Contact()
                                .name("Aakash Chaturvedi")
                                .email("aakash@example.com")
                                .url("https://example.com")
                        )
                );
    }
}
