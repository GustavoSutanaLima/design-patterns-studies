package edu.designpatterns.springboot.padrao_projeto_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto para estudo de padrão de projeto Spring. 
 * As seguintes dependências (ou módulos) serão utilizadas:
 * - Spring Data JPA;
 * - Spring Web;
 * - H2 Database;
 * - OpenFeign;
 * 
 * @autor Gustavo
 */

@EnableFeignClients //Habilida o Feign dentro do projeto;
@SpringBootApplication
public class PadraoProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadraoProjetoSpringApplication.class, args);
	}

}
