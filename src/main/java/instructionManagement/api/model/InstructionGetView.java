package instructionManagement.api.model;

import instructionManagement.model.InstructionType;

import java.util.List;

public class InstructionGetView {

    private Long id;
    private String titel;
    private String instructionType;
    private String shortDescription;
    private List<InstructionStepGetView> steps;

    public InstructionGetView() {
    }

    public InstructionGetView(String titel, String instructionType, String shortDescription, List<InstructionStepGetView> steps) {
        this.titel = titel;
        this.instructionType = instructionType;
        this.shortDescription = shortDescription;
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<InstructionStepGetView> getSteps() {
        return steps;
    }

    public void setSteps(List<InstructionStepGetView> steps) {
        this.steps = steps;
    }

    public String getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(String instructionType) {
        this.instructionType = instructionType;
    }
}
