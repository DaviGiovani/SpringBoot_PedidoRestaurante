package repository;

import model.Cozinheiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CozinheiroRepository extends JpaRepository<Cozinheiro,Long> {
}
