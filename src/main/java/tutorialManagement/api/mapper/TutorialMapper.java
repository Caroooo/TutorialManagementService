package tutorialManagement.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tutorialManagement.api.model.TutorialChildStepCreateView;
import tutorialManagement.api.model.TutorialCreateView;
import tutorialManagement.api.model.TutorialGetView;
import tutorialManagement.api.model.TutorialStepCreateView;
import tutorialManagement.model.Tutorial;
import tutorialManagement.model.TutorialChildStep;
import tutorialManagement.model.TutorialStep;

@Mapper(componentModel = "spring", uses = TutorialStepMapper.class)
public interface TutorialMapper {

    Tutorial createViewToTutorial(TutorialCreateView tutorialCreateView);

    TutorialGetView tutorialToGetView(Tutorial tutorial);

}
