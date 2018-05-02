package tutorialManagement.api.mapper;

import org.mapstruct.Mapper;
import tutorialManagement.api.model.TutorialChildStepCreateView;
import tutorialManagement.api.model.TutorialChildStepGetView;
import tutorialManagement.api.model.TutorialCreateView;
import tutorialManagement.api.model.TutorialStepCreateView;
import tutorialManagement.model.Tutorial;
import tutorialManagement.model.TutorialChildStep;
import tutorialManagement.model.TutorialStep;

@Mapper(componentModel = "spring", uses = {ResourceMapper.class, TutorialStepMapper.class})
public interface TutorialChildStepMapper {

    TutorialChildStep createViewToTutorialChildStep(TutorialChildStepCreateView tutorialChildStepCreateView);

    TutorialChildStepGetView tutorialChildStepToGetView(TutorialChildStep tutorialChildStep);
}
