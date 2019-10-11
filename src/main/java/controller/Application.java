package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Classe Principal da Aplicação, contêm o metodo main
 * @version 1.0 
 * @author Rafael dos Santos
 */

@SpringBootApplication /* Habilita a auto configuração do SpringBoot */
@EntityScan(basePackages = "model") /* Indica o pacote que contem as entidades do projeto */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
