package com.example.internseallegro;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
 * Template to
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Stars{
    public String full_name;
    public int stargazers_count;
}
public class RepoStars {
    private static final Logger log = LoggerFactory.getLogger(RepoStars.class);

    private final String login;
    public Stars[] stars;
    public RepoStars(String lg){
        //simple regex to filter out non-alphanumerical symbols excluding hyphens
        login = lg.replaceAll("([^A-Za-z0-9-])*","");
        stars = downloadRepos();
    }
    private Stars[] downloadRepos(){
        RestTemplate restTemplate = (new RestTemplateBuilder()).build();
        Stars[] s = restTemplate.getForEntity("https://api.github.com/users/"+ login +"/repos",Stars[].class).getBody();
        assert s != null;
        return s;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Stars s:stars){
            stringBuilder.append(s.full_name).append(" ").append(s.stargazers_count).append('\n');
        }
        return stringBuilder.toString();
    }
}
