package com.auth0.samples.githubclient.GithubService;

import com.auth0.samples.githubclient.models.GithubRepository;
import com.auth0.samples.githubclient.models.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

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
