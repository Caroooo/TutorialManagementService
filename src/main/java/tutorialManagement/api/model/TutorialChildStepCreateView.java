package tutorialManagement.api.model;

public class TutorialChildStepCreateView {

    private String titel;
    private String description;
    private long resourceId;


    public TutorialChildStepCreateView() {
    }

    public TutorialChildStepCreateView(String titel, String description, long resourceId) {
        this.titel = titel;
        this.description = description;
        this.resourceId = resourceId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }
}
