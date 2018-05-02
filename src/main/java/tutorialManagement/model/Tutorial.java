package tutorialManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tutorial {

    private Long id;
    private String titel;
    private String shortDescription;
    private List<TutorialStep> steps;

    public Tutorial() {
    }

    public Tutorial(String titel, String shortDescription, List<TutorialStep> steps) {
        this.titel = titel;
        this.shortDescription = shortDescription;
        this.steps = steps;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<TutorialStep> getSteps() {
        return steps;
    }

    public void setSteps(List<TutorialStep> steps) {
        this.steps = steps;
    }
}
