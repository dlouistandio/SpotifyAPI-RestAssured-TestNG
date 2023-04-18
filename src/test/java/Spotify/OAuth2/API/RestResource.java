package Spotify.OAuth2.API;

import Spotify.OAuth2.Pojo.Playlist;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static Spotify.OAuth2.API.Route.API;
import static Spotify.OAuth2.API.Route.TOKEN;
import static Spotify.OAuth2.API.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post (String path, String token, Object requestPlaylist){
        return given(getRequestSpec()).
                body(requestPlaylist).
                header("Authorization", "Bearer " + token).
        when().
                post(path).
        then().
                spec(getResponseSpec()).
                extract().response();
    }


    public static Response get (String path, String token){
        return given(getRequestSpec()).
                header("Authorization", "Bearer " + token).
        when().
                get(path).
        then().
                spec(getResponseSpec()).
                extract().response();

    }

    public static Response update (String path, String token, Object requestPlaylist){
       return given(getRequestSpec()).
                body(requestPlaylist).
                header("Authorization", "Bearer " + token).
       when().
               put(path).
       then().
               spec(getResponseSpec()).
               extract().response();
    }

    public static Response postAccount(HashMap<String, String> formParams){
        return given(getAccountRequestSpec()).
                contentType(ContentType.URLENC).
                formParams(formParams).
                log().all().
        when().
                post(API + TOKEN).
        then().
                spec(getResponseSpec()).
                extract().response();
    }
}
