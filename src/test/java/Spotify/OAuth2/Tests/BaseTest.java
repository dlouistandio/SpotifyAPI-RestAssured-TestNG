package Spotify.OAuth2.Tests;

import Spotify.OAuth2.API.StatusCode;
import Spotify.OAuth2.Pojo.Playlist.Error;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method m){
        System.out.println("Starting Test: " + m.getName());
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    @Step
    public void assertError(Error actualErr, StatusCode statusCode){
        assertThat(actualErr.getError().getStatus(), equalTo(statusCode.code));
        assertThat(actualErr.getError().getMessage(), equalTo(statusCode.msg));
    }
}
