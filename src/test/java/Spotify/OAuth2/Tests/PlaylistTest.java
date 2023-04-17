package Spotify.OAuth2.Tests;

import Spotify.OAuth2.Pojo.Error;
import Spotify.OAuth2.Pojo.Playlist;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String accessToken = "BQBQoT_Jcpf3MWkgzzfmZvfCVeSaJwRTDQnQlW7TwXFY-Q03-XO_lbctG5gZqGjvJ7lhntMqqhyeYa6GOljVD9he-XYvoYLlSahitlfh1Y22Db-3y7rvOjAA8km1EZlRioUiwWtMi32Vk852qQa7igQRh3Lbz35_233D2oFKcfBy-NWc_Lr_O62Pdl-OQ7hvkCzHzTZFIx1Ie1V5lJJ4waxSiBWzeP7eGTuL0PxDS4PnRroMnGqzX_7uUCRo5IV63NRYQfN5CYLLu7usJA";

    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.spotify.com").
                setBasePath("/v1").
                addHeader("Authorization", "Bearer " + accessToken).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
//                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void ableToCreatePlaylist(){
        Playlist requestPlaylist = new Playlist()
                .setName("Playlist apaan nih")
                .setDescription("Isinya apaan")
                .setPublic(false);

        Playlist responsePlaylist = given(requestSpecification).
                body(requestPlaylist).
        when().post("/users/31ekvnlbtpitm263y4qaoav6nske/playlists").
        then().spec(responseSpecification).
               assertThat().statusCode(201).
                extract().as(Playlist.class);

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

        Error error = given(requestSpecification).
                body(requestPlaylist).
                when().post("/users/31ekvnlbtpitm263y4qaoav6nske/playlists").
                then().spec(responseSpecification).
                assertThat().statusCode(400).
                extract().as(Error.class);

        assertThat(error.getError().getStatus(), equalTo(400));
        assertThat(error.getError().getMessage(), equalTo("Missing required field: name"));
    }

    @Test
    public void ableToGetPlaylist(){
        Playlist requestPlaylist = new Playlist()
                .setName("Playlist B Aja")
                .setDescription("Galau banget huhuhu")
                .setPublic(false);

        Playlist responsePlaylist = given(requestSpecification).
        when().get("/playlists/22qtOiiZgBLtosnLp1Yb4b").
        then().spec(responseSpecification).
        assertThat().statusCode(200).
        extract().as(Playlist.class);

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

        given(requestSpecification).
        body(requestPlaylist).
        when().put("/playlists/22qtOiiZgBLtosnLp1Yb4b").
        then().spec(responseSpecification).
        assertThat().statusCode(200);
    }
}
