
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

public class Image {

    @JsonProperty("height")
    Integer height;
    @JsonProperty("url")
    String url;
    @JsonProperty("width")
    Integer width;
}
