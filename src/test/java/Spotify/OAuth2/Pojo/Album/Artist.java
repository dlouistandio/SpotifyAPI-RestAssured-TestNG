
package Spotify.OAuth2.Pojo.Album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Artist {

    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    @JsonProperty("href")
    String href;
    @JsonProperty("id")
    String id;
    @JsonProperty("name")
    String name;
    @JsonProperty("type")
    String type;
    @JsonProperty("uri")
    String uri;

}
