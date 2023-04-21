package Spotify.OAuth2.Pojo.Playlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

//@Setter @Getter
@Jacksonized
@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
    @JsonProperty("error")
    InnerError error;
}