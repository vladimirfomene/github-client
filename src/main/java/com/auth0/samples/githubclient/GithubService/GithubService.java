package com.auth0.samples.githubclient.GithubService;

import java.io.IOException;
import java.util.List;


import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.springframework.stereotype.Service;

import com.auth0.samples.githubclient.models.GithubRepository;


@Service
public class GithubService implements APIConfiguration {

    Logger logger = LoggerFactory.getLogger(GithubService.class);

    private Retrofit retrofit = null;

    RepositoryInterface service = null;

    public GithubService(){
        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepositoryInterface.class);

    }


    public List<GithubRepository> getRepositories(){
        Call<List<GithubRepository>> reposCall = service.listRepos(ACCESS_TOKEN, API_VERSION_SPEC);

        Response<List<GithubRepository>> reposResponse = null;
        List<GithubRepository> repos = null;
        try {
            reposResponse = reposCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(reposResponse.isSuccessful()){
            repos = reposResponse.body();
            if(repos != null){
                logger.info("web request to Github was successfull");
            }else
                logger.info("Zero repositories found");
        }else{
            ResponseBody errorReponse = reposResponse.errorBody();
            if(errorReponse != null){
                logger.warn(errorReponse.toString());
            }
        }

        return repos;
    }


    public GithubRepository createRepository(GithubRepository repo){
        Call<GithubRepository> newRepoCall = service.createRepo(ACCESS_TOKEN, API_VERSION_SPEC, JSON_CONTENT_TYPE);

        Response<GithubRepository> newRepoResponse = null;
        GithubRepository newRepo = null;
        try {
            newRepoResponse = newRepoCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(newRepoResponse.isSuccessful()){
            repo = newRepoResponse.body();
            if(repo != null){
                logger.info("web request to Github was successfull");
            }else
                logger.info("Zero repositories found");
        }else{
            ResponseBody errorReponse = newRepoResponse.errorBody();
            if(errorReponse != null){
                logger.warn(errorReponse.toString());
            }
        }

        return repo;
    }

}
