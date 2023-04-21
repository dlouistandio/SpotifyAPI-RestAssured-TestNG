
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

public class ExternalUrls__1 {

    @JsonProperty("spotify")
    String spotify;

}
