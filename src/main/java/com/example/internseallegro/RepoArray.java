package com.example.internseallegro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


public class RepoArray {
    private static final Logger log = LoggerFactory.getLogger(RepoArray.class);

    private final String login;
    private final RepoData[] repos;
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
    private RepoData[] downloadRepos(){
        RestTemplate restTemplate = (new RestTemplateBuilder()).build();
        RepoData[] s = restTemplate.getForEntity("https://api.github.com/users/"+ login +"/repos", RepoData[].class).getBody();
        assert s != null;
        return s;
    }
    /*
     * Function that convert this object to
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
        return repos;
    }
}
