package postman.tests;

import applicationApi.WorkspacePage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PostWorkSpaceResponse;

public class postmanWorkSpaceRequestTest {

    WorkspacePage workspace = new WorkspacePage();
    String workspaceName = "My RestAssured workspace";
    String workspaceId;

    @Test(priority = 0)
    public void getPostmanWorkspaceTest(){
    workspace = new WorkspacePage();
    Response getworkspaceResponse = workspace.getWorkspaceApi();
    Assert.assertEquals("My Workspace",getworkspaceResponse.path("workspaces[0].name"));
    }

    @Test(priority = 1)
    public void postPostmanWorkspaceTest(){

        workspace = new WorkspacePage();
        PostWorkSpaceResponse postResponse = workspace.postWorkspaceApi(workspaceName,"personal","Workspace created from automation");
        Assert.assertEquals(workspaceName,postResponse.getWorkspace().getName());
        workspaceId = postResponse.getWorkspace().getId();
    }

    @Test(dependsOnMethods = "postPostmanWorkspaceTest")
    public void deletePostmanWorkspaceTest(){

        workspace = new WorkspacePage();
        workspace.deleteWorkspaceApi(workspaceId);
        Response getworkspaceResponse = workspace.workSpaceNotFound(workspaceId);
        Assert.assertEquals("Workspace not found",getworkspaceResponse.path("error.message"));
    }




}
