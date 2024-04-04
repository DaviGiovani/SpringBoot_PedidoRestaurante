package com.example.demo.controller;

import com.example.demo.model.Cozinheiro;
import com.example.demo.service.CozinheiroService;
import com.example.demo.service.PedidoService;
import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cozinheiros")
public class CozinheiroController {

    @Autowired
    CozinheiroService cozinheiroService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Cozinheiro> listarCozinheiros () {
        return cozinheiroService.listar();
    }

    @PostMapping
    public Cozinheiro criar (@RequestBody Cozinheiro cozinheiro) {
        return cozinheiroService.criar(cozinheiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cozinheiro cozinheiro) {
        //return funcionarioService.atualizar(id, funcionario);
        if(cozinheiroService.atualizar(cozinheiro, id) == null) {

            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
            //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cozinheiro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(cozinheiroService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }


    @GetMapping("/pedidos")
    public List<Pedido> visualizarPedidos () {
        return pedidoRepository.findAll();
    }

}
