package com.auth0.samples.githubclient.controllers;

import com.auth0.samples.githubclient.GithubService.GitHubService;
import com.auth0.samples.githubclient.models.GithubRepository;
import com.auth0.samples.githubclient.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class GithubClientController{

    @Autowired
    private GitHubService githubService;

    @GetMapping("/repos")
    public List<GithubRepository> getRepos() throws IOException {
        return githubService.getRepositories();
    }

    @PostMapping("/repos")
    public GithubRepository createRepo(@RequestBody GithubRepository newRepo){
        return githubService.createRepository(newRepo);
    }

    @DeleteMapping("/repos/{owner}/{repo}")
    public Status deleteRepo(@PathVariable("owner") String owner, @PathVariable("repo") String repoName){
        return githubService.deleteRepository(owner, repoName);
    }
}
