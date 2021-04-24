package com.example.internseallegro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Class that is used to parse data from downloaded JSON and to be parsed as JSON
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class RepoData {
    public String full_name;
    public int stargazers_count;
}
