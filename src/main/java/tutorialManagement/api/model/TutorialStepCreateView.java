package tutorialManagement.api.model;

import tutorialManagement.model.TutorialChildStep;

import java.util.List;

public class TutorialStepCreateView {

    private String titel;
    private String shortDescription;
    private List<TutorialChildStepCreateView> tutorialChildSteps;


    public TutorialStepCreateView() {
    }

    public TutorialStepCreateView(String titel, String shortDescription, List<TutorialChildStepCreateView> tutorialChildSteps) {
        this.titel = titel;
        this.shortDescription = shortDescription;
        this.tutorialChildSteps = tutorialChildSteps;
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

    public List<TutorialChildStepCreateView> getTutorialChildSteps() {
        return tutorialChildSteps;
    }

    public void setTutorialChildSteps(List<TutorialChildStepCreateView> tutorialChildSteps) {
        this.tutorialChildSteps = tutorialChildSteps;
    }
}
