package Spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import postman.utils.PropertyLoader;

import java.io.IOException;

public class spotifySpecBuilder {

    public static RequestSpecification getSpotifyRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
            return requestSpecBuilder.setBaseUri("https://accounts.spotify.com/").
                    setConfig(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().
                                    appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                    log(LogDetail.ALL).build();
        }


    public static ResponseSpecification getSpotifyResponseSpec(){
        ResponseSpecBuilder responseSpecBuilder	= new ResponseSpecBuilder();
        return responseSpecBuilder.expectStatusCode(200).
                log(LogDetail.ALL).
                build();
    }



}
