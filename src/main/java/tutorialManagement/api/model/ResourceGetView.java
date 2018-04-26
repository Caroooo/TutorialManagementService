package tutorialManagement.api.model;

import tutorialManagement.model.ResourceType;

public class ResourceGetView {

    private long id;
    private ResourceType resourceType;
    private String path;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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