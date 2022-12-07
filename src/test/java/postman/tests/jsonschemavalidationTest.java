package postman.tests;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class jsonschemavalidationTest {

    @Test
    public void validateJsonSchema(){
        File jsonPayload = new File("/Users/abdullasuhail/eclipse-workspace2/Rest/src/test/java/data/schemaValidatePayload.json");
        given().
                log().all().
                baseUri("https://postman-echo.com").
                header("Content-Type","application/json").
                queryParam("foo1","bar1").
                queryParam("foo2","bar2").
                body(jsonPayload).
        when().
                post("/post").
        then().
                log().all().
                assertThat().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("file.json"));
    }

}
