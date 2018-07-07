package instructionManagement.api.model;

import instructionManagement.model.InstructionType;

import java.util.List;

public class InstructionCreateView {

    private String titel;
    private InstructionType instructionType;
    private String shortDescription;
    private List<InstructionStepCreateView> steps;

    public InstructionCreateView() {
    }

    public InstructionCreateView(String titel, InstructionType instructionType, String shortDescription, List<InstructionStepCreateView> steps) {
        this.titel = titel;
        this.instructionType = instructionType;
        this.shortDescription = shortDescription;
        this.steps = steps;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<InstructionStepCreateView> getSteps() {
        return steps;
    }

    public void setSteps(List<InstructionStepCreateView> steps) {
        this.steps = steps;
    }

    public InstructionType getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(InstructionType instructionType) {
        this.instructionType = instructionType;
    }
}
