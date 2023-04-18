package Spotify.OAuth2.Tests;

import Spotify.OAuth2.API.ApplicationAPI.PlaylistAPI;
import Spotify.OAuth2.Pojo.Error;
import Spotify.OAuth2.Pojo.Playlist;
import Spotify.OAuth2.Utils.DataLoader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {

    @Test
    public void ableToCreatePlaylist(){
        Playlist requestPlaylist = new Playlist()
                .setName("Playlist apaan nih")
                .setDescription("Isinya apaan")
                .setPublic(false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(201));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
    }

    @Test
    public void notAbleToCreatePlaylist() {
        Playlist requestPlaylist = new Playlist()
                .setName("")
                .setDescription("Isinya apaan")
                .setPublic(false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(400));

        Error error = response.as(Error.class);

        assertThat(error.getError().getStatus(), equalTo(400));
        assertThat(error.getError().getMessage(), equalTo("Missing required field: name"));
    }

    @Test
    public void notAbleToCreatePlaylistWithInvalidToken() {
        String invalidToken = "12345";
        Playlist requestPlaylist = new Playlist()
                .setName("")
                .setDescription("Isinya apaan")
                .setPublic(false);

        Response response = PlaylistAPI.post(requestPlaylist, invalidToken);
        assertThat(response.statusCode(), equalTo(401));

        Error error = response.as(Error.class);

        assertThat(error.getError().getStatus(), equalTo(401));
        assertThat(error.getError().getMessage(), equalTo("Invalid access token"));
    }



    @Test
    public void ableToGetPlaylist(){
        Playlist requestPlaylist = new Playlist()
                .setName("Playlist B Aja")
                .setDescription("Isinya apaan")
                .setPublic(false);

        Response response = PlaylistAPI.get(DataLoader.getInstance().getPlaylistId());
        assertThat(response.statusCode(), equalTo(200));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
    }

    @Test
    public void ableToUpdatePlaylist(){
        Playlist requestPlaylist = new Playlist()
                .setName("Playlist B Aja")
                .setDescription("Isinya apaan")
                .setPublic(false);

        Response response = PlaylistAPI.update(requestPlaylist, DataLoader.getInstance().getUpdatePlaylistId());
        assertThat(response.statusCode(), equalTo(200));
    }
}
