package instructionManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Instruction {

    private Long id;
    private String titel;
    private InstructionType instructionType;
    private String shortDescription;
    private List<InstructionStep> steps;

    public Instruction() {
    }

    public Instruction(String titel, InstructionType instructionType, String shortDescription, List<InstructionStep> steps) {
        this.titel = titel;
        this.instructionType = instructionType;
        this.shortDescription = shortDescription;
        this.steps = steps;
    }

    @Id
    @GeneratedValue
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<InstructionStep> getSteps() {
        return steps;
    }

    public void setSteps(List<InstructionStep> steps) {
        this.steps = steps;
    }

    @Enumerated(EnumType.STRING)
    public InstructionType getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(InstructionType instructionType) {
        this.instructionType = instructionType;
    }
}
