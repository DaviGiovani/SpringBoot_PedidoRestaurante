package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Cozinheiro;
import com.example.demo.service.ClienteService;
import com.example.demo.model.Pedido;
import com.example.demo.model.ItemPedido;
import com.example.demo.service.CozinheiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    CozinheiroService cozinheiroService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente criar(@Valid @RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        //return clienteService.atualizar(id, cliente);
        if(clienteService.atualizar(id, cliente) == null) {

            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
           //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(clienteService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd-clientes")
    public int qtdClientes() {
        return clienteService.qtdClientes();
    }

    @GetMapping("/listar-clientes-5k")
    public List<Cliente> salarioMaior5k() {
        return clienteService.salarioMaior5k();
    }

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> fazerPedido(@RequestParam Long clienteId, @RequestBody List<ItemPedido> itens) {
        Cliente cliente = clienteService.buscarClientePorId(clienteId);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Pedido pedido = clienteService.fazerPedido(clienteId, itens);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/ricos/{x}")
    public List<Cliente> maiorX(@PathVariable double x) {
        return clienteService.maiorX(x);
    }

    @GetMapping("/busca-por-nome/{nome}")
    public List<Cliente> buscaPorNome(@PathVariable String nome) {
        return clienteService.buscaPorNome(nome);
    }

}
