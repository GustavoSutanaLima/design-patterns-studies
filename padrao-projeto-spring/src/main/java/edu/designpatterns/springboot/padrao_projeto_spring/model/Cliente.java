package edu.designpatterns.springboot.padrao_projeto_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
/*
 * A anotação @Entity no Spring Boot indica que uma classe representa uma entidade de banco de dados, 
 * permitindo que ela seja persistida e gerenciada por meio do Java Persistence API (JPA). 
 * Essa anotação é essencial para mapear objetos Java para tabelas no banco de dados.
 */
public class Cliente {
    /*
     * Adendo: anotações em Java não são encerradas por ponto-e-vírgula;
     */
    @Id //Espeficica que um determinado atributo é uma chave primária;
    @GeneratedValue(strategy = GenerationType.AUTO) //Definie a estratégia para geração de chave primária: neste caso, geração automática;
    private long id;

    private String nome;
    /*
     * Muitos-para-Um (ManyToOne):
     * O relacionamento muitos-para-um ocorre quando várias instâncias de uma entidade estão associadas a uma única 
     * instância de outra entidade.
     * Em outras palavras, várias entidades de um tipo específico se relacionam com uma única entidade de outro tipo.
     * Neste caso a entidade Endero está se associando com a entidade Cliente de movo que um memso Endereço pode estar
     * associado a multiplos clientes (entidade Cliente);
     */
    @ManyToOne
    private Endereco endereco;
    
    /*
     * Getters and Setters gerados pelo Source Action:
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco edereco) {
        this.endereco = edereco;
    }


    
}
