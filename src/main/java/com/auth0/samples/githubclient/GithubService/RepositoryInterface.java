package com.auth0.samples.githubclient.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import com.auth0.samples.githubclient.models.GithubRepository;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RepositoryInterface {

    @GET("user/repos")
    Call<List<GithubRepository>> listRepos(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec);

    @POST("user/repos")
    Call<GithubRepository> createRepo(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec,
                                      @Header("Content-Type") String contentType);
}
