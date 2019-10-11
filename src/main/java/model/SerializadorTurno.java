package model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializa o campo Turno em JSON, convertendo os chars N e D gravados no banco em
 * Noite e Dia.
 * @version 1.0 
 * @author Rafael dos Santos
 */

public class SerializadorTurno extends JsonSerializer<String>{
 
     
    @Override
    public void serialize(String dado, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        if (dado.equals("N")) {
        	generator.writeString("NOITE");
        }
        else {
        	if (dado.equals("D")) {
        		generator.writeString("DIA");
        	}else {
        		generator.writeString(dado);
        	}
        }
    	
     
     
    }

}
