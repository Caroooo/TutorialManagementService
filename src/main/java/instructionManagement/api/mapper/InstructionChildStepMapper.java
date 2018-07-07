package instructionManagement.api.mapper;

import org.mapstruct.Mapper;
import instructionManagement.api.model.InstructionChildStepCreateView;
import instructionManagement.api.model.InstructionChildStepGetView;
import instructionManagement.model.InstructionChildStep;

@Mapper(componentModel = "spring", uses = {ResourceMapper.class, InstructionStepMapper.class})
public interface InstructionChildStepMapper {

    InstructionChildStep createViewToInstructionChildStep(InstructionChildStepCreateView instructionChildStepCreateView);

    InstructionChildStepGetView instructionChildStepToGetView(InstructionChildStep instructionChildStep);
}
