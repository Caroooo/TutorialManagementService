package tutorialManagement.api.model;

import tutorialManagement.model.TutorialChildStep;

import java.util.List;

public class TutorialStepCreateView {

    private String titel;
    private List<TutorialChildStepCreateView> tutorialChildSteps;

    public TutorialStepCreateView() {
    }

    public TutorialStepCreateView(String titel, List<TutorialChildStepCreateView> tutorialChildSteps) {
        this.titel = titel;
        this.tutorialChildSteps = tutorialChildSteps;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public List<TutorialChildStepCreateView> getTutorialChildSteps() {
        return tutorialChildSteps;
    }

    public void setTutorialChildSteps(List<TutorialChildStepCreateView> tutorialChildSteps) {
        this.tutorialChildSteps = tutorialChildSteps;
    }
}
