package controller;


import model.Gerente;
import repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    GerenteRepository gerenteRepository;

    @GetMapping
    public List<Gerente> listarGerentes () {
        return gerenteRepository.findAll();
    }

    @PostMapping
    public Gerente criar (@RequestBody Gerente gerente) {
        return gerenteRepository.save(gerente);
    }
}
