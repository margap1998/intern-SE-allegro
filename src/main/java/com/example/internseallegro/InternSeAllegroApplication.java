package com.example.internseallegro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InternSeAllegroApplication {
    public static String token;
    public static void main(String[] args) {
        if(args.length>0){token = args[0];} else {token = "";}
        SpringApplication.run(InternSeAllegroApplication.class, args);
    }

    @GetMapping("/")
    public String[] start(){
        return new String[]{"/","/repos/{login}","/stars/{login}","/json/repos/{login}","/json/stars/{login}"};
    }
}
