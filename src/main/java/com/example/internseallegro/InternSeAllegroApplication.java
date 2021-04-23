package com.example.internseallegro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InternSeAllegroApplication {
    public static void main(String[] args) {
        SpringApplication.run(InternSeAllegroApplication.class, args);
    }
    @GetMapping("/")
    public void start(){

    }
    @GetMapping("/error")
    public void error(){

    }
}
