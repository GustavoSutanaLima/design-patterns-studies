package edu.designpatterns.springboot.padrao_projeto_spring.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.designpatterns.springboot.padrao_projeto_spring.model.Cliente;

/*
 * Cada uma das entidades precisa de um repository que funciona como uma INTERFACE provedora de métodos para acesso a dados:
 * Neste caso, temos a interface ClienteRepository.
 * ClieteRepository é uma interface que extende da Classe CrudRepository<T, ID(T)>. CrudRepository é como se fosse um Map<T(key),T(Value)>
 * e recebe o tipo de Objeto que faz referência, neste caso Cliente e o tipo de sua chave primária. Na classe cliente, 
 * a chave primária foi definida como um long;
 * CrudRepository é uma strategy, que diz quais serão as regras de implementação da interface Crud, neste caso;
 */
    /*
    * Como essa interface já estende diretamente do CrudRepository, o Spring já entende, que ela é um repositório,
    * o que permite omitir a anotação @Repository.
    */
@Repository 
    /*
     * A anotação @Repository no Spring Framework indica que uma classe é responsável 
     * por acessar e manipular dados em um banco de dados ou outra fonte de dados externa. 
     * Em resumo, ela marca a classe como um repositório de dados.
     */
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
