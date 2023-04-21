package Spotify.OAuth2.Tests;

import Spotify.OAuth2.API.ApplicationAPI.AlbumAPI;
import Spotify.OAuth2.API.StatusCode;
import Spotify.OAuth2.Pojo.Album.Album;
import Spotify.OAuth2.Utils.DataLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlbumTest extends BaseTest{

    @Step
    public Album albumBuilder(String id){
        return Album.builder().
                id(id).build();
    }

    @Step
    public void assertAlbumEquals(Album responseAlbum, Album requestAlbum){
        assertThat(responseAlbum.getId(), equalTo(requestAlbum.getId()));
    }

    @Test(description = "Get Album with valid ID")
    public void ableToGetAlbums(){
        Album requestAlbum = albumBuilder("4aawyAB9vmqN3uQ7FjRGTy");

        Response response = AlbumAPI.get(DataLoader.getInstance().getAlbumId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertAlbumEquals(response.as(Album.class), requestAlbum);

    }
}
