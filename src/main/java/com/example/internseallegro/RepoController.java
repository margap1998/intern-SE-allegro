package com.example.internseallegro;

import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RepoController {
    @GetMapping("/stars/{login}")
    public String starCount(@PathVariable String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        int st = (new RepoArray(login)).sumOfStars();
        return String.valueOf(st);
    }
    @GetMapping("/json/stars/{login}")
    public StarsSum starCountJSON(@PathVariable String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        return new StarsSum((new RepoArray(login)).sumOfStars());
    }

    @GetMapping("/json/repos/{login}")
    public RepoData[] repos(@PathVariable String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        return (new RepoArray(login)).getRepos();
    }
    @GetMapping("/repos/{login}")
    public String reposRaw(@PathVariable String login) throws MissingRequestValueException {
        if(login.contentEquals("")){
            throw new MissingRequestValueException("Missing username");
        }//Exception thrown if someone forget to put username in request path
        return (new RepoArray(login)).toString();
    }
}
