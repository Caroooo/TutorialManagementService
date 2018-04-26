package tutorialManagement.api.model;

import tutorialManagement.model.Tutorial;

import java.util.List;


public class TutorialsGetView {

    private List<TutorialGetView> tutorials;

    public List<TutorialGetView> getTutorials() {
        return tutorials;
    }

    public void setTutorials(List<TutorialGetView> tutorials) {
        this.tutorials = tutorials;
    }

}
