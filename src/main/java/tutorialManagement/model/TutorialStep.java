package tutorialManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TutorialStep {

    private long id;
    private String titel;
    private List<TutorialChildStep> tutorialChildSteps;

    public TutorialStep() {
    }

    public TutorialStep(long id, String titel, List<TutorialChildStep> tutorialChildSteps) {
        this.id = id;
        this.titel = titel;
        this.tutorialChildSteps = tutorialChildSteps;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<TutorialChildStep> getTutorialChildSteps() {
        return tutorialChildSteps;
    }

    public void setTutorialChildSteps(List<TutorialChildStep> tutorialChildSteps) {
        this.tutorialChildSteps = tutorialChildSteps;
    }
}
