package instructionManagement.api.model;

import java.util.List;

public class InstructionStepGetView {

    private long id;
    private String titel;
    private String shortDescription;
    private List<InstructionChildStepGetView> instructionChildSteps;

    public InstructionStepGetView() {
    }

    public InstructionStepGetView(long id, String titel, String shortDescription, List<InstructionChildStepGetView> instructionChildSteps) {
        this.id = id;
        this.titel = titel;
        this.shortDescription = shortDescription;
        this.instructionChildSteps = instructionChildSteps;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<InstructionChildStepGetView> getInstructionChildSteps() {
        return instructionChildSteps;
    }

    public void setInstructionChildSteps(List<InstructionChildStepGetView> instructionChildSteps) {
        this.instructionChildSteps = instructionChildSteps;
    }
}
