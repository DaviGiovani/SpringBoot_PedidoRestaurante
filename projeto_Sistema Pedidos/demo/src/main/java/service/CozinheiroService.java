package service;

import model.Cozinheiro;
import repository.CozinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinheiroService {

    @Autowired
    CozinheiroRepository cozinheiroRepository;

    public List<Cozinheiro> listarCozinheiros() {
        return cozinheiroRepository.findAll();
    }

    public Cozinheiro criar(Cozinheiro cozinheiro) {
        return cozinheiroRepository.save(cozinheiro);
    }

    public Cozinheiro atualizar(Long id, Cozinheiro cozinheiro) {
        //verificar se o id é valido
        if(cozinheiroRepository.existsById(id)) {
            //atualizar o objeto na base
            cozinheiro.setId(id);
            return cozinheiroRepository.save(cozinheiro);
        }
        return null;
        // não realiza nenhuma alteração
    }

    public boolean deletar(Long id) {
        if(cozinheiroRepository.existsById(id)) {
            cozinheiroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdCozinheiros () {
        return cozinheiroRepository.findAll().size();
    }
}

