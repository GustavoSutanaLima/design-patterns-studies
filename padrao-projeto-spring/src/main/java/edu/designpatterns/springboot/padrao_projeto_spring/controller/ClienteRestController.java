package edu.designpatterns.springboot.padrao_projeto_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.designpatterns.springboot.padrao_projeto_spring.model.Cliente;
import edu.designpatterns.springboot.padrao_projeto_spring.service.ClienteService;
import feign.Response;


@RestController
/*
 * A anotação @RestController é uma combinação de duas outras anotações do Spring: @Controller e @ResponseBody. 
 * Ela é usada para simplificar a criação de controladores que retornam dados diretamente em vez de renderizar 
 * uma visão (como uma página HTML).
 */
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired //clienteService é agora gerenciado pelo Spring Boot;
    /*
     * Não é possível instanciar uma interface, por isso, quando o spring rodar
     * ele irá enteder que, quando clienteService inicializado (abaixo), ele (Spring Boot) irá instanciar
     * a classe ClienteServiceImplementacao que implementa a interface ClienteService;
     */
    private ClienteService clienteService; 


    @GetMapping("/saudacao")
    public String saudacao() {  
        return "Olá, mundo!";
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() { //retorna todos os ids;
        return ResponseEntity.ok(clienteService.buscarTodos());
    }
    /*
     * @GetMapping("/{id}"): Define que o método buscarPorId
     * deve ser chamado quando uma requisição GET é feita para uma URL que segue o padrão clientes/{id}
     * a parte clientes está no atributo da anotação RequestMapping;
     */

    @GetMapping("/{id}") //retorna um usário por id
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }   

    @PostMapping() //inclui usuários
    /*
     * PostMapping("/usuarios"): Define que o método abaixo dessa anotaçao deve ser
     * chamado quando uma requisição POST é feita para a URL /usuarios.
     * 
    */
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    /*
     * A anotação @PutMapping é usada para mapear requisições HTTP PUT para métodos específicos em um controlador. 
     * O método PUT é geralmente usado para ATUALIZAR recursos existentes.
     * 
     * A anotação @PathVariable é usada para extrair valores de variáveis de caminho da URL e passá-los 
     * como parâmetros para o método do controlador. Isso é útil quando você precisa capturar partes 
     * dinâmicas da URL: OU SEJA, QUANDO A URL clientes/{id} (seja "clientes"definida no RequestMapping da Classe
     * controladora e {id}, um id que será passado na url), FOR ACESSADA O id DA URL SERÁ PASSADA AO
     * COMO ATRIBUTO DE UM MÉTODO.
     * 
     * A anotação @RequestBody é usada para mapear o corpo da requisição HTTP para um objeto Java. 
     * Isso permite que você receba dados JSON ou XML enviados pelo cliente e os converta em objetos 
     * Java para processamento: OU SEJA, PEGO O QUE TENHO DE INFORMAÇÃO DENTRO DE UMA URL (ainda não tenho
     * 100% de certeza que é isso mesmo) E USO 
     * ESSA ANOTAÇÃO PARA CONVERTER ESSA INFORMAÇÃO (OU CORPO) EM UM OBJETO JAVA;
     */

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}") //A anotação @DeleteMapping é usada para remover uma informação;
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();

    }

}
