package Spotify.OAuth2.API.ApplicationAPI;

import Spotify.OAuth2.API.RestResource;
import Spotify.OAuth2.Pojo.Playlist.Playlist;
import Spotify.OAuth2.Utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static Spotify.OAuth2.API.Route.PLAYLISTS;
import static Spotify.OAuth2.API.Route.USERS;
import static Spotify.OAuth2.API.TokenManager.getToken;

public class PlaylistAPI {

    @Step
    public static Response post (Playlist requestPlaylist){
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, getToken(), requestPlaylist);
    }
    @Step
    public static Response post (Playlist requestPlaylist, String token){
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, token, requestPlaylist);
    }
    @Step
    public static Response get (String playlistID){
        return RestResource.get(PLAYLISTS + "/" + playlistID, getToken());
    }
    @Step
    public static Response update (Playlist requestPlaylist, String playlistID){
        return RestResource.update(PLAYLISTS + "/" + playlistID, getToken(), requestPlaylist);
    }
}
