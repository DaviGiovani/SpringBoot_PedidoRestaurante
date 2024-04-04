package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Cozinheiro;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.CozinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Pedido;
import com.example.demo.model.ItemPedido;
import com.example.demo.repository.PedidoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        //verificar se o id é valido
        if(clienteRepository.existsById(id)) {
            //atualizar o objeto na base
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
        // não realiza nenhuma alteração
    }

    public boolean deletar(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdClientes () {
        return clienteRepository.findAll().size();
    }

    public List<Cliente> salarioMaior5k() {
        List<Cliente> listaDeClientes = listarClientes();
        List<Cliente> listaDeClientes5k = new ArrayList<>();

        for(Cliente cliente : listaDeClientes) {
            if(cliente.getSalario() > 5000) {
                System.out.println(cliente.getNome());
                listaDeClientes5k.add(cliente);
            }
        }
        return listaDeClientes5k;

    }
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> maiorX(double x) {
        List<Cliente> listaDeClientes = listarClientes();
        List<Cliente> listaDeClienteRicos = new ArrayList<>();

        for(Cliente cliente : listaDeClientes) {
            if(cliente.getSalario() > x) {
                listaDeClienteRicos.add(cliente);
            }
        }
        return listaDeClienteRicos;
    }

    public List<Cliente> buscaPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Pedido fazerPedido(Long idCliente, List<ItemPedido> itens) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente != null) {
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setItens(itens);
            pedido.setStatus("PENDENTE");
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public List<Pedido> listarPedidosDoCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente != null) {
            return pedidoRepository.findByCliente(cliente);
        }
        return new ArrayList<>();
    }

}
