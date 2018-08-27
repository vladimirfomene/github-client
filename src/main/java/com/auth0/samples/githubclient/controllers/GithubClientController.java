package com.auth0.samples.githubclient.controllers;

import com.auth0.samples.githubclient.GithubService.GithubService;
import com.auth0.samples.githubclient.models.GithubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GithubClientController{

    @Autowired
    private GithubService githubService;

    @GetMapping("/repos")
    public List<GithubRepository> getRepos(){
        return githubService.getRepositories();
    }
}
