package instructionManagement.api.mapper;

import org.mapstruct.Mapper;
import instructionManagement.api.model.ResourceCreateView;
import instructionManagement.api.model.ResourceGetView;
import instructionManagement.model.Resource;

@Mapper(componentModel = "spring", uses = InstructionChildStepMapper.class)
public interface ResourceMapper {

    Resource createViewToResource(ResourceCreateView resourceCreateView);

    ResourceGetView resourceToGetView(Resource resource);
}
