package com.auth0.samples.githubclient.GithubService;

import java.util.List;

import com.auth0.samples.githubclient.models.Status;
import retrofit2.Call;
import retrofit2.http.*;

import com.auth0.samples.githubclient.models.GithubRepository;

public interface RepositoryInterface {

    @GET("user/repos")
    Call<List<GithubRepository>> listRepos(@Header("Authorization") String accessToken,
                                           @Header("Accept") String apiVersionSpec);

    @DELETE("repos/{owner}/{repo}")
    Call<Status> deleteRepo(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec,
                            @Path("repo") String repo, @Path("owner") String owner);

    @POST("user/repos")
    Call<GithubRepository> createRepo(@Body GithubRepository repo, @Header("Authorization") String accessToken,
                                      @Header("Accept") String apiVersionSpec,
                                      @Header("Content-Type") String contentType);
}
