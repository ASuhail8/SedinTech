package postman.tests;

import applicationApi.WorkspacePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.PostWorkSpaceResponse;

public class multipleTestDataTest {


    @Test(dataProvider = "getData")
    public void multipleTestData(String workspaceName,String type,String desc){

        WorkspacePage workspacePage = new WorkspacePage();
        PostWorkSpaceResponse postResponse = workspacePage.postWorkspaceApi(workspaceName, type, desc);
        Assert.assertEquals(workspaceName,postResponse.getWorkspace().getName());

    }

    @DataProvider
    public Object[][] getData(){
       Object[][] data = { {"workspace1","personal","desc1"},
               {"workspace2","personal","desc2"},
               {"workspace3","personal","desc3"},
               {"workspace4","personal","desc4"},
               {"workspace5","personal","desc5"}};
        return data;

    }

}
