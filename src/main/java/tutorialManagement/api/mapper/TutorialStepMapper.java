package tutorialManagement.api.mapper;

import org.mapstruct.Mapper;
import tutorialManagement.api.model.TutorialChildStepCreateView;
import tutorialManagement.api.model.TutorialCreateView;
import tutorialManagement.api.model.TutorialStepCreateView;
import tutorialManagement.api.model.TutorialStepGetView;
import tutorialManagement.model.Tutorial;
import tutorialManagement.model.TutorialChildStep;
import tutorialManagement.model.TutorialStep;

@Mapper(componentModel = "spring", uses = TutorialChildStepMapper.class)
public interface TutorialStepMapper {

    TutorialStep createViewToTutorialStep(TutorialStepCreateView tutorialStepCreateView);

    TutorialStepGetView tutorialStepToGetView(TutorialStep tutorialStep);
}
