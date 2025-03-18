package com.leang.homework002;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Online learning platform"
        )
)
public class Homework002Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework002Application.class, args);
    }

}
