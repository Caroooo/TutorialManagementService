package tutorialManagement.model;

import javax.persistence.*;

@Entity
public class Resource {

    private long id;
    private ResourceType resourceType;
    private String path;
    private String originalName;
    private TutorialChildStep tutorialChildStep;

    public Resource() {
    }

    public Resource(long id, ResourceType resourceType, String path, String originalName, TutorialChildStep tutorialChildStep) {
        this.id = id;
        this.resourceType = resourceType;
        this.path = path;
        this.originalName = originalName;
        this.tutorialChildStep = tutorialChildStep;
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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @OneToOne
    public TutorialChildStep getTutorialChildStep() {
        return tutorialChildStep;
    }

    public void setTutorialChildStep(TutorialChildStep tutorialChildStep) {
        this.tutorialChildStep = tutorialChildStep;
    }
}
