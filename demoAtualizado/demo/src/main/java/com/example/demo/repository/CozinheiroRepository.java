package com.example.demo.repository;

import com.example.demo.model.Cozinheiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CozinheiroRepository extends JpaRepository<Cozinheiro, Long> {

}
