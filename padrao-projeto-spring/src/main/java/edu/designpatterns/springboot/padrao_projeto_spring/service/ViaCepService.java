package edu.designpatterns.springboot.padrao_projeto_spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.designpatterns.springboot.padrao_projeto_spring.model.Endereco;

/*
 * Client HTTP, criado via OpenFeign, para consumo da API do ViaCep.
 * 
    * CLIENTE HTTP:é como um mensageiro que você usa para enviar e receber cartas (ou mensagens) pela internet. 
    * Imagine que você quer saber a previsão do tempo. Você escreve uma carta pedindo essa informação e 
    * entrega ao mensageiro (cliente HTTP). Ele leva sua carta até o serviço de previsão do tempo (servidor) 
    * e traz de volta a resposta com a previsão.
        * Em termos técnicos:
        * Cliente HTTP: O programa que faz a solicitação (como um navegador ou um aplicativo);
        * Servidor HTTP: O programa que recebe a solicitação, processa e envia a resposta (como um site ou uma API);
        * Então, um cliente HTTP é simplesmente a parte do seu programa que envia pedidos e recebe respostas 
        * pela internet

    * OpenFeign é uma biblioteca do Spring Cloud que facilita a criação de clientes HTTP de forma declarativa. 
    * Em vez de escrever código manualmente para fazer chamadas HTTP, você define uma INTERFACE que descreve 
    * as chamadas que deseja fazer, e o Spring Boot cuida da implementação.

    * A anotação @FeignClient é usada para definir um cliente HTTP de forma declarativa. 
    * Isso significa que você pode criar INTERFACES JAVA que representam chamadas para APIs REST, 
    * e o Spring Boot cuidará da implementação dessas chamadas

    * O atributo name ou value é obrigatório e define um nome arbitrário para o cliente Feign;
    * O atributo url especifica a URL base da API que o cliente Feign irá consumir.

    * Dentro da interface anotada com @FeignClient, você define métodos que correspondem às chamadas HTTP 
    * que deseja fazer.
    * Você pode usar anotações do Spring MVC como @GetMapping, @PostMapping, @RequestMapping, etc.
*/
@FeignClient(name = "viacep" , url = "https://viacep.com.br/ws")
public interface ViaCepService {

    /*
     * Quando você usa @RequestMapping dentro de um Feign Client, você pode definir de maneira 
     * detalhada como as requisições devem ser feitas para a API externa. Isso é útil quando 
     * você precisa de mais controle sobre as requisições do que o fornecido pelas anotações 
     * específicas como @GetMapping ou @PostMapping.
         * @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json"): 
         * Mapeia uma requisição GET para o endpoint /{cep}/json.
      */
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json")
    //@ResquestMapping pode ser substituido por @GetMapping("/{cep}/json")
    /*
     * @PathVariable("cep"): Extrai o valor da variável de caminho {cep} e o passa como parâmetro para o método consultar cep:
     * No caso, o valor que estiver no caminho cep será passado para o método consultarCep como se fosse
     * o objeto do tipo String cepString;
     */
    Endereco consultarCep(@PathVariable("cep") String cepString);
}
