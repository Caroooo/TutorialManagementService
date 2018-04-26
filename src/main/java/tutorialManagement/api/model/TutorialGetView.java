package tutorialManagement.api.model;

import tutorialManagement.model.TutorialStep;

import java.util.List;

public class TutorialGetView {

    private Long id;
    private String titel;
    private String shortDescription;
    private List<TutorialStepGetView> steps;

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

    public List<TutorialStepGetView> getSteps() {
        return steps;
    }

    public void setSteps(List<TutorialStepGetView> steps) {
        this.steps = steps;
    }
}
