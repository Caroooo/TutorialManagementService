package instructionManagement.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import instructionManagement.services.InstructionTypeSerializer;

import javax.persistence.Entity;

@JsonSerialize(using = InstructionTypeSerializer.class)
public enum InstructionType {
    WERKSTUECK("Werkstück einspannen"),
    WERKZEUG ("Maschine mit Werkzeug bestücken"),
    WARTUNG ("Wartungsaufgabe");

    private final String value;

    InstructionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName(){
        return name();
    }
    @Override
    public String toString() {
        return name();
    }

    @JsonCreator
    public static InstructionType fromText(String text){
        if(WERKSTUECK.equals(text) || InstructionType.WERKSTUECK.value.equals(text)){
            return InstructionType.WERKSTUECK;
        }else if(WERKZEUG.equals(text) || InstructionType.WERKZEUG.value.equals(text)){
            return InstructionType.WERKZEUG;
        }else if(WARTUNG.equals(text) || InstructionType.WARTUNG.value.equals(text)){
            return InstructionType.WARTUNG;
        }
        return InstructionType.WARTUNG;
    }
}
