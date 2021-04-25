package com.example.internseallegro;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;


public class RepoArray {
    private final String login;
    private final LinkedList<RepoData> repos;
    public int sumOfStars(){
        int sumOfStars = 0;
        for (RepoData r:repos){
            sumOfStars+=r.stargazers_count;
        }
        return sumOfStars;
    }
    public RepoArray(String lg){
        //simple regex to filter out non-alphanumerical symbols excluding hyphens
        login = lg.replaceAll("([^A-Za-z0-9-])*","");
        repos = downloadRepos();
    }
    /*
     * Function that downloads data form GitHub API
     */
    private LinkedList<RepoData> downloadRepos(){
        RestTemplateBuilder rtb = new RestTemplateBuilder();
        if (InternSeAllegroApplication.token.equals("")){
            rtb = rtb.defaultHeader("Authorization","token "+InternSeAllegroApplication.token);
        }
        RestTemplate restTemplate = rtb.build();
        int page =1;
        LinkedList<RepoData> a = new LinkedList<>();
        while (true) {
            RepoData[] r = restTemplate.getForEntity("https://api.github.com/users/" + login + "/repos?per_page=100&page="+ page, RepoData[].class).getBody();
            if (r == null) {break;}
            if (r.length == 0) {break;}
            page+=1;
            a.addAll(Arrays.asList(r));
        }
        return a;
    }
    /*
     * Function that convert this object to string
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(RepoData s:repos){
            stringBuilder.append(s.full_name).append(" ").append(s.stargazers_count).append("\n");
        }
        return stringBuilder.toString();
    }
    public RepoData[] getRepos(){
        RepoData[] a = new RepoData[repos.size()];
        return repos.toArray(a);
    }
}
