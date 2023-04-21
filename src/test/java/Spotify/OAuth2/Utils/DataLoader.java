package Spotify.OAuth2.Utils;

import java.util.Properties;

public class DataLoader {
    private  final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader(){
        properties = PropertyUtils.propertyLoader("src/main/resources/data.properties");
    }

    public static DataLoader getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getPlaylistId(){
        String props = properties.getProperty("get_playlist_id");
        if(props != null) return props;
        else throw new RuntimeException("get_playlist_id in properties file is null");
    }

    public String getUpdatePlaylistId(){
        String props = properties.getProperty("update_playlist_id");
        if(props != null) return props;
        else throw new RuntimeException("update_playlist_id in properties file is null");
    }

    public String getAlbumId(){
        String props = properties.getProperty("get_album_id");
        if(props != null) return props;
        else throw new RuntimeException("get_album_id in properties file is null");
    }

}
