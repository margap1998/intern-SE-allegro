package com.example.internseallegro;

import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RepoController {
    @GetMapping("/stars")
    public int starCount(@RequestParam(value = "login",defaultValue = "") String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        int sumOfStars = (new RepoStars(login)).sumOfStars();
        return sumOfStars;
    }

    @GetMapping("/json/repos")
    public Stars[] repos(@RequestParam(value = "login",defaultValue = "") String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        return (new RepoStars(login)).repos;
    }
    @GetMapping("/repos")
    public String reposRaw(@RequestParam(value = "login",defaultValue = "") String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        return (new RepoStars(login)).toString();
    }
}
