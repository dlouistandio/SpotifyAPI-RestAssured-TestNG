package Spotify.OAuth2.Tests;

import Spotify.OAuth2.API.ApplicationAPI.PlaylistAPI;
import Spotify.OAuth2.API.StatusCode;
import Spotify.OAuth2.Pojo.Playlist.Error;
import Spotify.OAuth2.Pojo.Playlist.Playlist;
import Spotify.OAuth2.Tests.BaseTest;
import Spotify.OAuth2.Utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Spotify.OAuth2.Utils.FakerUtils.generateDescription;
import static Spotify.OAuth2.Utils.FakerUtils.generateName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Spotify API")
@Feature("Playlist")
@Link(name = "allure", type = "mylink")
@Issue("1")
@TmsLink("TMS Link")
public class PlaylistTest extends BaseTest {
    @Step
    public Playlist playlistBuilder(String name, String description, boolean _public){
        return Playlist.builder().
                name(name).
                description(description).
                _public(_public).
                build();
    }
    @Step
    public void assertPlaylistEqual(Playlist responsePlaylist, Playlist requestPlaylist){
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.get_public(), equalTo(requestPlaylist.get_public()));
    }

    @Story("Valid Create Playlist")
    @Description("User create the playlist with valid data")
    @Test(description = "Create Playlist With Valid Data")
    public void ableToCreatePlaylist(){
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Story("Invalid Create Playlist")
    @Description("User create the playlist with invalid data")
    @Test(description = "Create Playlist With Invalid Data")
    public void notAbleToCreatePlaylist() {
        Playlist requestPlaylist = playlistBuilder("", generateDescription(), false);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_400);
        assertError(response.as(Error.class), StatusCode.CODE_400);
    }

    @Story("Invalid Create Playlist")
    @Description("User create the playlist with invalid token")
    @Test(description = "Create Playlist With Invalid Token")
    public void notAbleToCreatePlaylistWithInvalidToken() {
        String invalidToken = "12345";
        Playlist requestPlaylist = playlistBuilder("", generateDescription(), false);

        Response response = PlaylistAPI.post(requestPlaylist, invalidToken);
        assertStatusCode(response.statusCode(), StatusCode.CODE_401);
        assertError(response.as(Error.class), StatusCode.CODE_401);
    }

    @Story("Valid Get Playlist")
    @Description("User get the playlist with valid token")
    @Test(description = "Get Playlist With Valid Token")
    public void ableToGetPlaylist(){
        Playlist requestPlaylist = playlistBuilder("Playlist30hXZT,dK0_m_,_","Description E&B.&&.43_5u+4y_EXZ0K__5&+ j+", false);

        Response response = PlaylistAPI.get(DataLoader.getInstance().getPlaylistId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Story("Valid Update Playlist")
    @Description("User update the playlist with valid token")
    @Test(description = "Update Playlist With Valid Token")
    public void ableToUpdatePlaylist(){
        Playlist requestPlaylist = playlistBuilder(generateName(),  generateDescription(), false);

        Response response = PlaylistAPI.update(requestPlaylist, DataLoader.getInstance().getUpdatePlaylistId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
    }
}
