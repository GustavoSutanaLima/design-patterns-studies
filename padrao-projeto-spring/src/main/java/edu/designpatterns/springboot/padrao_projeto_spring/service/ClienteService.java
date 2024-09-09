package edu.designpatterns.springboot.padrao_projeto_spring.service;

import org.springframework.stereotype.Service;

import edu.designpatterns.springboot.padrao_projeto_spring.model.Cliente;


/*
 * Em um projeto Spring Boot, não é estritamente necessário anotar uma interface de serviço com @Service. 
 * No entanto, a anotação @Service é uma prática comum e recomendada para marcar suas interfaces de serviço;
 *  
 * Quando você anota uma classe com @Service, o Spring a reconhece como um componente 
 * gerenciado pelo contêiner de injeção de dependência;
 * 
 * Essa anotação também ajuda a organizar e categorizar suas classes, 
 * tornando mais claro o papel de cada uma no seu código.
 */
@Service
public interface ClienteService {
    /*
     * Definindo uma interface de Serviço:
     * Essa inteface pode ser entendida como a estratégia a ser seguida pelos serviços relacionados
     * ao domínio cliente;
    */
        /*
        * Métodos de Contrato da interface ClienteService:
        */
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId (Long id);

    void inserir(Cliente cliete);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);



}
