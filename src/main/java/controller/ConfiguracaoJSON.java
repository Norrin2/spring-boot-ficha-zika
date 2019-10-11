package controller;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Bean de configuração dos JSONs gerados pela aplicação.
 * Assegura a formatação conforme especificado.
 * @version 1.0 
 * @author Rafael dos Santos
 */

@Configuration
public class ConfiguracaoJSON{

    @SuppressWarnings("rawtypes")
    @Bean
    public Module springDataPageModule() {
        return new SimpleModule().addSerializer(Page.class, new JsonSerializer<Page>() {
            @Override
            public void serialize(Page value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeStartObject();
                gen.writeFieldName("conteudo");
                serializers.defaultSerializeValue(value.getContent(), gen);
                gen.writeNumberField("numeroDaPagina", value.getNumber());
                gen.writeNumberField("quantidadeDePaginas", value.getTotalPages());
                gen.writeNumberField("tamanhoDaPagina", value.getNumberOfElements());
                gen.writeEndObject();
            }
        });
    }

    
}
