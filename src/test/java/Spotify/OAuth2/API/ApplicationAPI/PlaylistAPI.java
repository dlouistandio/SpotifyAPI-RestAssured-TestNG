package Spotify.OAuth2.API.ApplicationAPI;

import Spotify.OAuth2.API.RestResource;
import Spotify.OAuth2.Pojo.Playlist;
import io.restassured.response.Response;

import static Spotify.OAuth2.API.SpecBuilder.getRequestSpec;
import static Spotify.OAuth2.API.SpecBuilder.getResponseSpec;
import static Spotify.OAuth2.API.TokenManager.renewToken;
import static io.restassured.RestAssured.given;

public class PlaylistAPI {

    public static Response post (Playlist requestPlaylist){
        return RestResource.post("/users/31ekvnlbtpitm263y4qaoav6nske/playlists", renewToken(), requestPlaylist);
    }

    public static Response post (Playlist requestPlaylist, String token){
        return RestResource.post("/users/31ekvnlbtpitm263y4qaoav6nske/playlists", token, requestPlaylist);
    }

    public static Response get (String playlistID){
        return RestResource.get("/playlists/" + playlistID, renewToken());
    }

    public static Response update (Playlist requestPlaylist, String playlistID){
        return RestResource.update("/playlists/" + playlistID, renewToken(), requestPlaylist);
    }
}
