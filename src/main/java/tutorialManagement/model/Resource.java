package tutorialManagement.model;

import javax.persistence.*;

@Entity
public class Resource {

    private long id;
    private ResourceType resourceType;
    private String path;

    public Resource() {
    }

    public Resource(long id, ResourceType resourceType, String path) {
        this.id = id;
        this.resourceType = resourceType;
        this.path = path;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
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
