package instructionManagement.api.model;

import java.util.List;


public class InstructionsGetView {

    private List<InstructionGetView> instructions;

    public List<InstructionGetView> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<InstructionGetView> instructions) {
        this.instructions = instructions;
    }

}
