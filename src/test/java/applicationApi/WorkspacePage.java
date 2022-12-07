package applicationApi;

import io.restassured.response.Response;
import pojo.PostWorkSpaceRequest;
import pojo.PostWorkSpaceResponse;
import pojo.WorkSpaceRequest;

import static Spec.SpecBuilder.getRequestSpec;
import static Spec.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class WorkspacePage {

    public Response getWorkspaceApi()  {
        return given().
                spec(getRequestSpec()).
        when().
                get().
        then().
                spec(getResponseSpec()).
                extract().
                response();
    }

    public PostWorkSpaceResponse postWorkspaceApi(String workspaceName, String type, String desc){
        WorkSpaceRequest workSpaceRequest = new WorkSpaceRequest(workspaceName,type,desc);
        PostWorkSpaceRequest postWorkSpaceRequest = new PostWorkSpaceRequest(workSpaceRequest);

        return given().
                spec(getRequestSpec()).
                body(postWorkSpaceRequest).
        when().
                post().
        then().
                spec(getResponseSpec()).
                extract().
                response().
                as(PostWorkSpaceResponse.class);
    }

    public void deleteWorkspaceApi(String workspaceId){
        given().
                spec(getRequestSpec()).
        when().
                delete("/"+workspaceId+"").
        then().
                spec(getResponseSpec());
    }

    public Response workSpaceNotFound(String workspaceId){
        return given().
                spec(getRequestSpec()).
        when().
                get("/"+workspaceId+"").
        then().
                assertThat().
                statusCode(404).
                extract().
                response();
    }


}
