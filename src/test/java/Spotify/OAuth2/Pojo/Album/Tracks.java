
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
public class Tracks {

    @JsonProperty("href")
    String href;
    @JsonProperty("items")
    List<Item> items;
    @JsonProperty("limit")
    Integer limit;
    @JsonProperty("next")
    Object next;
    @JsonProperty("offset")
    Integer offset;
    @JsonProperty("previous")
    Object previous;
    @JsonProperty("total")
    Integer total;

}
