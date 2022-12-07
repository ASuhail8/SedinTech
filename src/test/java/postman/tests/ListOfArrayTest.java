package postman.tests;

import org.testng.annotations.Test;
import pojo.RootList;
import pojo.RootResponse;
import pojo.SomelistRequest;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ListOfArrayTest {

    @Test
    public void arrayOfArrayTest(){

        SomelistRequest list1 = new SomelistRequest("hal","bangalore");
        SomelistRequest list2 = new SomelistRequest("hal2","bangalore2");

        ArrayList<SomelistRequest> arrayList = new ArrayList<>();
        arrayList.add(list1);
        arrayList.add(list2);

        RootList rootList = new RootList("suhail","31", arrayList);

        List<RootList> a = new ArrayList<>();
        a.add(rootList);

        RootResponse rootResponse = given().
                log().all().
                baseUri("https://postman-echo.com").
                body(a).
                when().
                post("/post").
                then().
                log().all().
                assertThat().
                statusCode(200).
                extract().
                response().
                as(RootResponse.class);

        for(int i=0;i<rootResponse.getData().size();i++){
            //Validation can be done here
        }

    }

}
