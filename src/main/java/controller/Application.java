package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Classe Principal da Aplica��o, cont�m o metodo main
 * @version 1.0 
 * @author Rafael dos Santos
 */

@SpringBootApplication /* Habilita a auto configura��o do SpringBoot */
@EntityScan(basePackages = "model") /* Indica o pacote que contem as entidades do projeto */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
