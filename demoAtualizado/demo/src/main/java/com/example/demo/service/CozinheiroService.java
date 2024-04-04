package com.example.demo.service;

import com.example.demo.model.Cozinheiro;
import com.example.demo.repository.CozinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Pedido;
import com.example.demo.model.ItemPedido;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoService;

import java.util.Collections;
import java.util.List;

@Service
public class CozinheiroService implements PessoaService<Cozinheiro>{

    @Autowired
    CozinheiroRepository cozinheiroRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> visualizarPedidos() {
        return pedidoRepository.findAll();
    }
    @Override
    public List<Cozinheiro> listar() {
        return cozinheiroRepository.findAll();
    }

    @Override
    public Cozinheiro criar(Cozinheiro cozinheiro) {
        return cozinheiroRepository.save(cozinheiro);
    }

    @Override
    public Cozinheiro atualizar(Cozinheiro cozinheiro, Long id) {
        if (cozinheiroRepository.existsById(id)) {
            cozinheiro.setId(id);
            return cozinheiroRepository.save(cozinheiro);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if(cozinheiroRepository.existsById(id)) {
            cozinheiroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public Cozinheiro buscarCozinheiroPorId(Long id) {
        return cozinheiroRepository.findById(id).orElse(null);
    }
}
