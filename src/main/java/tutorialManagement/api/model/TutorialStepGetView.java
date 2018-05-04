package tutorialManagement.api.model;

import java.util.List;

public class TutorialStepGetView {

    private long id;
    private String titel;
    private String shortDescription;
    private List<TutorialChildStepGetView> tutorialChildSteps;

    public TutorialStepGetView() {
    }

    public TutorialStepGetView(long id, String titel, String shortDescription, List<TutorialChildStepGetView> tutorialChildSteps) {
        this.id = id;
        this.titel = titel;
        this.shortDescription = shortDescription;
        this.tutorialChildSteps = tutorialChildSteps;
    }

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<TutorialChildStepGetView> getTutorialChildSteps() {
        return tutorialChildSteps;
    }

    public void setTutorialChildSteps(List<TutorialChildStepGetView> tutorialChildSteps) {
        this.tutorialChildSteps = tutorialChildSteps;
    }
}
