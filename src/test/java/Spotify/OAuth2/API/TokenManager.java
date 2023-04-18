package Spotify.OAuth2.API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static Spotify.OAuth2.API.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class TokenManager {

    public static String renewToken(){
        HashMap<String , String> formParams = new HashMap<>();

        formParams.put("grant_type", "refresh_token");
        formParams.put("refresh_token", "AQA1UEilAOc0uLElXcTsvvaYQranfK9KPb8JqBBEIM3cIYVtZtWCGUtN4nrHqGA_acN8Az_kxFH_GJ40bFF2g4lFbx-WNt924Rkx1AQUVTmOAKG0n_wLokFMudjGzpAIXnw");
        formParams.put("client_id", "08a5f0124f6d430facb77e5bb514a80b");
        formParams.put("client_secret", "247ca39eee5a40bbbfae99ca9d68fddd");

       Response response = given().baseUri("https://accounts.spotify.com").
                contentType(ContentType.URLENC).
                formParams(formParams).
        when().post("/api/token").
        then().spec(getResponseSpec()).
                extract().response();

       if(response.statusCode() != 200){
           throw new RuntimeException("Abort!! Renwe Token Fail");
       }
       return response.path("access_token");
    }
}
