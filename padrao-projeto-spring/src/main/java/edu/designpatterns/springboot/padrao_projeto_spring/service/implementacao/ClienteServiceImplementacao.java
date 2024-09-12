package edu.designpatterns.springboot.padrao_projeto_spring.service.implementacao;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.designpatterns.springboot.padrao_projeto_spring.model.Cliente;
import edu.designpatterns.springboot.padrao_projeto_spring.model.Endereco;
import edu.designpatterns.springboot.padrao_projeto_spring.model.repositories.ClienteRepository;
import edu.designpatterns.springboot.padrao_projeto_spring.model.repositories.EnderecoRepository;
import edu.designpatterns.springboot.padrao_projeto_spring.service.ClienteService;
import edu.designpatterns.springboot.padrao_projeto_spring.service.ViaCepService;

@Service
public class ClienteServiceImplementacao implements ClienteService{

    @Autowired //Injeção de dependência para o repositório de clientes
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository; 

    @Autowired
    private ViaCepService viaCepService; //Client HTTP 

    @Override
    public Iterable<Cliente> buscarTodos() {
        /*
         * Onde serão buscados os clientes ? No repositório de clientes, ou seja, ClienteRepository:
         *      Para isso, iremos injetar as depentes relacioadas à este repositório usando o @Autowired;
         */
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id); //Um Optional é um objeto que pode ou não ser nulo;
        return cliente.get(); //Objetos do tipo Optinal possuem um método chamado get(); que retorna o valor, e se não 
        //houver valor, lança uma exceção que não consta nenhum valor;
    }

    @Override
    public void inserir(Cliente cliente) {
        /* Como se verificar se o cliente tem um endereço? O objeto Cliente possui um atributo do tipo Endereço,
         * no entanto, o próprio endereço é uma Entidade independente, tanto é que possui um repositório.
         */
        /* Antes de procurar pelo endereço em seu repositório, vamos pegar o cep do cliente, 
        * cep é o Id da entidade Endereço:
        */
        getEndereco(cliente);
        //Salvando o cliente (com o novo endeço no repositório de clientes)
        clienteRepository.save(cliente);
        
    }

    
    @Override
    public void atualizar(Long id, Cliente cliente) {
        /*
         * Para atualizar um cliente, eu preciso primeiramente fazer a busca pelo 
         * id do cliente no respositório de clintes
         */
        Optional<Cliente> clienteNoBancoDeDados = clienteRepository.findById(id);
        /*
        * Se clienteNoBancoDeDados está presente (ou seja se não for nulo), retorna true,
        * caso contrário, retorna false;
        */
        if(clienteNoBancoDeDados.isPresent()) {
            clienteNoBancoDeDados.get().setNome(cliente.getNome());
            getEndereco(clienteNoBancoDeDados.get());
            clienteRepository.save(clienteNoBancoDeDados.get());
        } 
    }
    
    @Override
    public void deletar(Long id) {
        //Busca no repositório de clientes se exista um cliente com este id:
        Optional<Cliente> clienteNoBancoDeDados = clienteRepository.findById(id);
        //Verifica se clienteNoBancoDeDados está presente no repositório:
        if(clienteNoBancoDeDados.isPresent()){
            //deleta o cliente do repositório de cliente pelo id;
            clienteRepository.deleteById(id);
        }
    }
    
    private void getEndereco(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
    
        //Procurando no repositório de endereços, se já existe o Cep do cliente lá cadastrado;
        Optional<Endereco> enderecoCliente = enderecoRepository.findById(cep); 
        /*
         * O Método findById do CrudRepository retorna um Optional<T>; Objetos do tipo Optional<T> possuem um
         * método chamado .orElseGet(); Esse método recebe como argumento uma expressão lamba.
         * () -> {return Objet<T>}
         * Caso o Optional esteja vazio, ou seja, null algum outro objeto será retornado. Este o objeto é do
         * tipo do Optional. Neste caso, do tipo Entedeço;
         */
    
        Endereco endereco = enderecoCliente.orElseGet(() -> {
            //Usando o FeignCliente ViaCep e o metodo consultarCep(Cep cep) para retornar o endereço deste cep;
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            //Salvando o o novo endereço do cep em questão no repositório de endereços:
            enderecoRepository.save(novoEndereco);
            return novoEndereco;    
        });
        //Setando o novo endereço para o cliente;
        cliente.setEndereco(endereco);
    }

}
