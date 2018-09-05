# Spring Boot GitHub Client Using Retrofit

## Ide and Tools
* I used Intellij IDE to develop this sample application. 
* I created a skeleton of the project from [Spring Boot's bootstrap site](https://start.spring.io/)
* Specified Gradle as my build system and selected web for my dependencies.

## App Dependencies
* Spring Boot starter web and Spring Boot starter test for handling HTTP requests
* JAXB to add support for Java 10.
* Retrofit, which is Square's HTTP client used for quering the GitHub api.
* Google Gson, which converts POJOs to JSON and vice-versa.
* Retrofit Gson converter, to handle the conversion of http response body from JSON to POJOs and HTTP request
body from POJOs to JSON.

## App Setup
* Create a GitHub account if you don't already have one. Go to the settings page. On the settings page click 
on the developer settings button and on the developer settings page click on personal access token. You will be taken
 to your personal access token page creation. On this page click on the `Generate Token` button to create a new token. 
 But don't worry about this section, I have already created a token for you.
 
* Once you have your token, clone this project by running the following command in your command line
`git clone https://github.com/vladimirfomene/github-client.git`.

* Once you have a copy of the project, move into the repository with **cd**. Then follow the path 
`/github-client/src/main/java/com/auth0/samples/githubclient/GithubService/APIConfiguration.java`
`
* In that interface file, replace the text `<Access-Token-Here>` in the ACCESS_TOKEN property with your generated GitHub access token.

* Build the project with Gradle and then run the application. 

## Testing Rest Client
* Run the following request using any HTTP client of your choice (Curl, Postman or even a browser).

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
replace {owner} with your GitHub account name and {repo} with your GitHub repository name. If you are testing 
with my personal access token, my account name is `vladimirfomene`.