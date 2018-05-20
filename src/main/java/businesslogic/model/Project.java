package businesslogic.model;

public class Project {
    private String projectId;
    private String projectName;
    private String projectOwner;

    public Project(String projectId, String projectName, String projectOwner) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectOwner = projectOwner;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectOwner='" + projectOwner + '\'' +
                '}';
    }
}
