package tutorialManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TutorialStep {

    private long id;
    private String titel;
    private List<TutorialChildStep> tutorialChildSteps;
    private Tutorial tutorial;


    public TutorialStep() {
    }

    public TutorialStep(long id, String titel, List<TutorialChildStep> tutorialChildSteps, Tutorial tutorial) {
        this.id = id;
        this.titel = titel;
        this.tutorialChildSteps = tutorialChildSteps;
        this.tutorial = tutorial;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<TutorialChildStep> getTutorialChildSteps() {
        return tutorialChildSteps;
    }

    public void setTutorialChildSteps(List<TutorialChildStep> tutorialChildSteps) {
        this.tutorialChildSteps = tutorialChildSteps;

    }

    @ManyToOne
    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }
}
