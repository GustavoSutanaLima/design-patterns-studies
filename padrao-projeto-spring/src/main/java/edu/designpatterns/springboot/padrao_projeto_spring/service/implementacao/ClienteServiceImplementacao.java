package edu.designpatterns.springboot.padrao_projeto_spring.service.implementacao;

import org.springframework.stereotype.Service;

import edu.designpatterns.springboot.padrao_projeto_spring.model.Cliente;
import edu.designpatterns.springboot.padrao_projeto_spring.service.ClienteService;

@Service
public class ClienteServiceImplementacao implements ClienteService{

    @Override
    public Iterable<Cliente> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inserir(Cliente cliete) {
        // TODO Auto-generated method stub
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
    }

}
