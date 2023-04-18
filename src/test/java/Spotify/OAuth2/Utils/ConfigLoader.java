package Spotify.OAuth2.Utils;

import java.util.Properties;

public class ConfigLoader {
    private  final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/main/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId(){
        String props = properties.getProperty("client_id");
        if(props != null) return props;
        else throw new RuntimeException("client_id in properties file is null");
    }

    public String getGrantType(){
        String props = properties.getProperty("grant_type");
        if(props != null) return props;
        else throw new RuntimeException("grant_type in properties file is null");
    }

    public String getRefreshToken(){
        String props = properties.getProperty("refresh_token");
        if(props != null) return props;
        else throw new RuntimeException("refresh_token in properties file is null");
    }

    public String getClientSecret(){
        String props = properties.getProperty("client_secret");
        if(props != null) return props;
        else throw new RuntimeException("client_secret in properties file is null");
    }

    public String getUserId(){
        String props = properties.getProperty("user_id");
        if(props != null) return props;
        else throw new RuntimeException("user_id in properties file is null");
    }
}
