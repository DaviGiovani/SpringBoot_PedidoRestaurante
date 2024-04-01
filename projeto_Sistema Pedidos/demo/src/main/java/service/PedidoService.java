package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import repository.PedidoRepository;
import model.Pedido;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void enviarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }
}
