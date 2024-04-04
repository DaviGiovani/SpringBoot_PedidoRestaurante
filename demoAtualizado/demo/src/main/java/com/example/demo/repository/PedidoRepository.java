package com.example.demo.repository;
import com.example.demo.model.Cliente;
import com.example.demo.model.Cozinheiro;
import com.example.demo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByCliente(Cliente cliente);
    List<Pedido> findByStatus(String status);

}
