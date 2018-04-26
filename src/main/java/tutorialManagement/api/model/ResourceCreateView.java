package tutorialManagement.api.model;

import tutorialManagement.model.ResourceType;

public class ResourceCreateView {

    private ResourceType resourceType;
    private String path;

    public ResourceCreateView() {
    }

    public ResourceCreateView(ResourceType resourceType, String path) {
        this.resourceType = resourceType;
        this.path = path;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
