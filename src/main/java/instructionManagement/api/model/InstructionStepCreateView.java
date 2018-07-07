package instructionManagement.api.model;

import java.util.List;

public class InstructionStepCreateView {

    private String titel;
    private String shortDescription;
    private List<InstructionChildStepCreateView> instructionChildSteps;


    public InstructionStepCreateView() {
    }

    public InstructionStepCreateView(String titel, String shortDescription, List<InstructionChildStepCreateView> instructionChildSteps) {
        this.titel = titel;
        this.shortDescription = shortDescription;
        this.instructionChildSteps = instructionChildSteps;
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

    public List<InstructionChildStepCreateView> getInstructionChildSteps() {
        return instructionChildSteps;
    }

    public void setInstructionChildSteps(List<InstructionChildStepCreateView> instructionChildSteps) {
        this.instructionChildSteps = instructionChildSteps;
    }
}
