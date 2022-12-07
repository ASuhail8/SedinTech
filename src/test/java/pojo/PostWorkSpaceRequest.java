package pojo;

public class PostWorkSpaceRequest {

    private WorkSpaceRequest workspace;

    public PostWorkSpaceRequest(WorkSpaceRequest workspace) {
        this.workspace = workspace;
    }

    public WorkSpaceRequest getWorkspace() {
        return workspace;
    }

    public void setWorkspace(WorkSpaceRequest workspace) {
        this.workspace = workspace;
    }
}
