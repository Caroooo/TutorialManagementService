package tutorialManagement.api.model;

import tutorialManagement.model.Resource;

public class TutorialChildStepCreateView {

    private String titel;
    private String description;
    private ResourceCreateView resource;


    public TutorialChildStepCreateView() {
    }

    public TutorialChildStepCreateView(String titel, String description, ResourceCreateView resource) {
        this.titel = titel;
        this.description = description;
        this.resource = resource;

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

    public ResourceCreateView getResource() {
        return resource;
    }

    public void setResource(ResourceCreateView resource) {
        this.resource = resource;
    }

   }
