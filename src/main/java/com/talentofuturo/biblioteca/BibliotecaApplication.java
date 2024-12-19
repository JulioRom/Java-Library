package com.talentofuturo.biblioteca;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Biblioteca").version("1.0.0").description("Almacen de libros"));
    }
}
