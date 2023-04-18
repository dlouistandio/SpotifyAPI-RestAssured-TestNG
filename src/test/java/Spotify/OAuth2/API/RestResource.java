package Spotify.OAuth2.API;

import Spotify.OAuth2.Pojo.Playlist;
import io.restassured.response.Response;

import static Spotify.OAuth2.API.SpecBuilder.getRequestSpec;
import static Spotify.OAuth2.API.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post (String path, String token, Object requestPlaylist){
        return given(getRequestSpec()).
                body(requestPlaylist).
                header("Authorization", "Bearer " + token).
                when().post(path).
                then().spec(getResponseSpec()).
                extract().response();
    }


    public static Response get (String path, String token){
        return given(getRequestSpec()).
                header("Authorization", "Bearer " + token).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().response();

    }

    public static Response update (String path, String token, Object requestPlaylist){
       return given(getRequestSpec()).
                body(requestPlaylist).
                header("Authorization", "Bearer " + token).
                when().put(path).
                then().spec(getResponseSpec()).
                extract().response();
    }
}
