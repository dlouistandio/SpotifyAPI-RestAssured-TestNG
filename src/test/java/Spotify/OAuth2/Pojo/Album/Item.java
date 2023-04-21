
package Spotify.OAuth2.Pojo.Album;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Item {

    @JsonProperty("artists")
    List<Artist__1> artists;
    @JsonProperty("available_markets")
    List<String> availableMarkets;
    @JsonProperty("disc_number")
    Integer discNumber;
    @JsonProperty("duration_ms")
    Integer durationMs;
    @JsonProperty("explicit")
    Boolean explicit;
    @JsonProperty("external_urls")
    ExternalUrls__3 externalUrls;
    @JsonProperty("href")
    String href;
    @JsonProperty("id")
    String id;
    @JsonProperty("is_local")
    Boolean isLocal;
    @JsonProperty("name")
    String name;
    @JsonProperty("preview_url")
    String previewUrl;
    @JsonProperty("track_number")
    Integer trackNumber;
    @JsonProperty("type")
    String type;
    @JsonProperty("uri")
    String uri;

}
