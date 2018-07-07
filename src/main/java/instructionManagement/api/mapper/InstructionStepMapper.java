package instructionManagement.api.mapper;

import org.mapstruct.Mapper;
import instructionManagement.api.model.InstructionStepCreateView;
import instructionManagement.api.model.InstructionStepGetView;
import instructionManagement.model.InstructionStep;

@Mapper(componentModel = "spring", uses = {InstructionChildStepMapper.class, InstructionMapper.class})
public interface InstructionStepMapper {

    InstructionStep createViewToInstructionStep(InstructionStepCreateView instructionStepCreateView);

    InstructionStepGetView instructionStepToGetView(InstructionStep instructionStep);
}
