package tutorialManagement.api.model;

import tutorialManagement.model.ResourceType;

public class ResourceCreateView {

    private long id;

    public ResourceCreateView() {
    }

    public ResourceCreateView(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
