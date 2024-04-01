package service;

import model.Gerente;
import repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GerenteService implements PessoaService<Gerente>{

    @Autowired
    GerenteRepository gerenteRepository;

    @Override
    public List<Gerente> listar() {
        return gerenteRepository.findAll();
    }

    @Override
    public Gerente criar(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @Override
    public Gerente atualizar(Gerente gerente, Long id) {
        if(gerenteRepository.existsById(id)) {
            gerente.setId(id);
            return gerenteRepository.save(gerente);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if(gerenteRepository.existsById(id)) {
            gerenteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

