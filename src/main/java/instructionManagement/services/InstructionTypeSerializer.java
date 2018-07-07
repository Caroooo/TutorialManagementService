package instructionManagement.services;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import instructionManagement.model.InstructionType;

import java.io.IOException;

public class InstructionTypeSerializer extends StdSerializer<InstructionType> {

    public InstructionTypeSerializer() {
        super(InstructionType.class);
    }

    public void serialize(InstructionType type, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("name");
        generator.writeString(type.name());
        generator.writeFieldName("value");
        generator.writeString(type.getValue());
        generator.writeEndObject();
    }
}
