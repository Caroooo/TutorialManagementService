package instructionManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class InstructionStep {

    private long id;
    private String titel;
    private String shortDescription;
    private List<InstructionChildStep> instructionChildSteps;
    private Instruction instruction;


    public InstructionStep() {
    }

    public InstructionStep(long id, String titel, String shortDescription, List<InstructionChildStep> instructionChildSteps, Instruction instruction) {
        this.id = id;
        this.titel = titel;
        this.shortDescription = shortDescription;
        this.instructionChildSteps = instructionChildSteps;
        this.instruction = instruction;
    }

    @Id
    @GeneratedValue
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<InstructionChildStep> getInstructionChildSteps() {
        return instructionChildSteps;
    }

    public void setInstructionChildSteps(List<InstructionChildStep> instructionChildSteps) {
        this.instructionChildSteps = instructionChildSteps;

    }

    @ManyToOne
    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}
