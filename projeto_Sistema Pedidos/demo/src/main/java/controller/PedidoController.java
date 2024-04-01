package controller;
import model.Pedido;
import service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarPedido(@RequestBody Pedido pedido) {
        pedidoService.enviarPedido(pedido);
        return ResponseEntity.ok("Pedido enviado com sucesso!");
    }

    @GetMapping("/visualizar")
    public ResponseEntity<List<Pedido>> visualizarPedidos() {
        List<Pedido> pedidos = pedidoService.getPedidos();
        return ResponseEntity.ok(pedidos);
    }
}

