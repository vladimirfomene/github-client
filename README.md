# SpringBoot Github Client Using Retrofit

## Ide and Tools
* I used Intellij IDE to develop this sample application. 
* I created a skeleton of the project from [Springboot's bootstrap site](https://start.spring.io/)
* Specified gradle as my build system and selected web for my dependencies.

## App Dependencies
* Springboot starter web and Springboot starter test for handling http requests
* JAXB to add support for Java 10.
* Retrofit, which is Square's http client used for quering the github api.
* Google Gson, which converts POJOs to json and vice-versa.
* Retrofit Gson converter, to handle the conversion of http response body from Json to POJOs and http request
body from POJOs to Json.

## App Setup
* Create a github account if you don't already have one. Go to the settings page. On the settings page click 
on the developer settings button and on the developer settings page click on personal access token. You will be taken
 to your personal access token page creation. On this page click on the `Generate Token` button to create a new token. 
 But don't worry about this section, I have already created a token for you.
 
* Once you have your token, clone this project by running the following command in your command line
`git clone https://github.com/vladimirfomene/github-client.git`.

* Once you have a copy of the project, move into the repository with **cd**. Then follow the path 
`/github-client/src/main/java/com/auth0/samples/githubclient/GithubService/APIConfiguration.java`
`
* In that interface file, replace the text `<Access-Token-Here>` in the ACCESS_TOKEN property with your generated Github access token.

* Build the project with Gradle and then run tha application. 

## Testing Rest Client
* Run the following request using any http client of your choice (curl, postman or even your browser).

* For getting a list of your repositories run, `GET http://localhost:8080/repos`
* For creating a new repository in your account run, `POST http://localhost:8080/repos` with the following
request body:
````    {
      "name": "Fomene-Test-Github-client",
      "description": "This is a test repository created using our github client",
      "homepage": "https://github.com",
      "private": false,
      "has_issues": true,
      "has_projects": true,
      "has_wiki": true
    }
````
You can change the above repository attributes to fit your personal repository information.

* Finally, delete the created repository by executing the following request, `DELETE http://localhost:8080/repos/{owner}/{repo}`
replace {owner} with your github account name and {repo} with your github repository name. If you are testing 
with my personal access token, my account name is `vladimirfomene`.