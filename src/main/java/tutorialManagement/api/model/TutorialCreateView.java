package tutorialManagement.api.model;

import tutorialManagement.model.TutorialStep;

import java.util.List;

public class TutorialCreateView {

    private String titel;
    private String shortDescription;
    private List<TutorialStepCreateView> steps;

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

    public List<TutorialStepCreateView> getSteps() {
        return steps;
    }

    public void setSteps(List<TutorialStepCreateView> steps) {
        this.steps = steps;
    }
}
