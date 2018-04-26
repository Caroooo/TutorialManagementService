package tutorialManagement.api.model;


public class TutorialChildStepGetView {

    private long id;
    private String titel;
    private String description;
    private ResourceGetView resource;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ResourceGetView getResource() {
        return resource;
    }

    public void setResource(ResourceGetView resource) {
        this.resource = resource;
    }
}
