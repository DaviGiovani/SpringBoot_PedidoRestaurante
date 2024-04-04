package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Pedido;
import com.example.demo.model.ItemPedido;
import com.example.demo.repository.PedidoRepository;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido fazerPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
    public List<Pedido> listarPedidosPorStatus(String status) {
        return pedidoRepository.findByStatus(status);
    }

}
