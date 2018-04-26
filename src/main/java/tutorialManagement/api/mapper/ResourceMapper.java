package tutorialManagement.api.mapper;

import org.mapstruct.Mapper;
import tutorialManagement.api.model.ResourceCreateView;
import tutorialManagement.api.model.ResourceGetView;
import tutorialManagement.model.Resource;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    Resource createViewToResource(ResourceCreateView resourceCreateView);

    ResourceGetView resourceToGetView(Resource resource);
}
