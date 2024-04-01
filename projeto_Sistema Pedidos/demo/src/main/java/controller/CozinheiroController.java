package controller;

import model.Cozinheiro;
import repository.CozinheiroRepository;
import service.CozinheiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinheiros")
public class CozinheiroController {

    @Autowired
    CozinheiroService cozinheiroService;

    @GetMapping
    public List<Cozinheiro> listarCozinheiros() {
        return cozinheiroService.listarCozinheiros();
    }

    @PostMapping
    public Cozinheiro criar(@Valid @RequestBody Cozinheiro cozinheiro) {
        return cozinheiroService.criar(cozinheiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cozinheiro cozinheiro) {
        //return cozinheiroService.atualizar(id, cozinheiro);
        if(cozinheiroService.atualizar(id, cozinheiro) == null) {

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

    @GetMapping("/qtd-cozinheiros")
    public int qtdCozinheiros() {
        return cozinheiroService.qtdCozinheiros();
    }

}

