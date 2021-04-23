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
        int sumOfStars = 0;
        Stars[] stars = (new RepoStars(login)).stars;
        for(Stars s:stars){
            sumOfStars+=s.stargazers_count;
        }
        return sumOfStars;
    }

    @GetMapping("/repos")
    public RepoStars repos(@RequestParam(value = "login",defaultValue = "") String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        return (new RepoStars(login));
    }
}
