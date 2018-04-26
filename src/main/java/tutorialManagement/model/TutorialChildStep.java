package tutorialManagement.model;

import javax.persistence.*;

@Entity
public class TutorialChildStep {

    private long id;
    private String titel;
    private String description;
    private Resource resource;


    public TutorialChildStep() {
    }

    public TutorialChildStep(long id, String titel, String description, Resource resource) {
        this.id = id;
        this.titel = titel;
        this.description = description;
        this.resource = resource;
    }

    @Id
    @GeneratedValue
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
