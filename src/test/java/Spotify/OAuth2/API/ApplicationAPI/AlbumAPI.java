package Spotify.OAuth2.API.ApplicationAPI;

import Spotify.OAuth2.API.RestResource;
import Spotify.OAuth2.Pojo.Album.Album;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static Spotify.OAuth2.API.Route.ALBUMS;
import static Spotify.OAuth2.API.TokenManager.getToken;

public class AlbumAPI {

    @Step
    public static Response get(String albumId){
        return RestResource.get(ALBUMS + "/" + albumId, getToken());
    }

}
