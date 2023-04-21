
package Spotify.OAuth2.Pojo.Album;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Album {

    @JsonProperty("album_group")
    String albumGroup;
    @JsonProperty("album_type")
    String albumType;
    @JsonProperty("artists")
    List<Artist> artists;
    @JsonProperty("available_markets")
    List<String> availableMarkets;
    @JsonProperty("copyrights")
    List<Copyright> copyrights;
    @JsonProperty("external_ids")
    ExternalIds externalIds;
    @JsonProperty("external_urls")
    ExternalUrls__1 externalUrls;
    @JsonProperty("genres")
    List<Object> genres;
    @JsonProperty("href")
    String href;
    @JsonProperty("id")
    String id;
    @JsonProperty("images")
    List<Image> images;
    @JsonProperty("label")
    String label;
    @JsonProperty("name")
    String name;
    @JsonProperty("popularity")
    Integer popularity;
    @JsonProperty("release_date")
    String releaseDate;
    @JsonProperty("release_date_precision")
    String releaseDatePrecision;
    @JsonProperty("total_tracks")
    Integer totalTracks;
    @JsonProperty("tracks")
    Tracks tracks;
    @JsonProperty("type")
    String type;
    @JsonProperty("uri")
    String uri;
}
