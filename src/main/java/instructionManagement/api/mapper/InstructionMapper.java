package instructionManagement.api.mapper;

import org.mapstruct.Mapper;
import instructionManagement.api.model.InstructionCreateView;
import instructionManagement.api.model.InstructionGetView;
import instructionManagement.model.Instruction;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = InstructionStepMapper.class)
public interface InstructionMapper {

    Instruction createViewToInstruction(InstructionCreateView instructionCreateView);

    @Mapping(source = "instructionType.name", target = "instructionType")
    InstructionGetView instructionToGetView(Instruction instruction);

}
