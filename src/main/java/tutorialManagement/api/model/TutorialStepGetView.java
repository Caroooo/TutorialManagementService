package tutorialManagement.api.model;

import java.util.List;

public class TutorialStepGetView {

    private long id;
    private String titel;
    private List<TutorialChildStepGetView> tutorialChildSteps;

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

    public List<TutorialChildStepGetView> getTutorialChildSteps() {
        return tutorialChildSteps;
    }

    public void setTutorialChildSteps(List<TutorialChildStepGetView> tutorialChildSteps) {
        this.tutorialChildSteps = tutorialChildSteps;
    }
}
