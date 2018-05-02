package tutorialManagement.api.mapper;

import org.mapstruct.Mapper;
import tutorialManagement.api.model.ResourceCreateView;
import tutorialManagement.api.model.ResourceGetView;
import tutorialManagement.model.Resource;
import tutorialManagement.model.TutorialChildStep;

@Mapper(componentModel = "spring", uses = TutorialChildStepMapper.class)
public interface ResourceMapper {

    Resource createViewToResource(ResourceCreateView resourceCreateView);

    ResourceGetView resourceToGetView(Resource resource);
}
