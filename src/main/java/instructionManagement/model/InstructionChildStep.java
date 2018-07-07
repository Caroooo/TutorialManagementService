package instructionManagement.model;

import javax.persistence.*;

@Entity
public class InstructionChildStep {

    private long id;
    private String titel;
    private String description;
    private Resource resource;
    private InstructionStep instructionStep;



    public InstructionChildStep() {
    }

    public InstructionChildStep(long id, String titel, String description, Resource resource, InstructionStep instructionStep) {
        this.id = id;
        this.titel = titel;
        this.description = description;
        this.resource = resource;
        this.instructionStep = instructionStep;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @ManyToOne
    public InstructionStep getInstructionStep() {
        return instructionStep;
    }

    public void setInstructionStep(InstructionStep instructionStep) {
        this.instructionStep = instructionStep;
    }
}
