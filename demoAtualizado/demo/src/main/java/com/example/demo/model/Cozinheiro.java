package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Cozinheiro extends Cliente {
    private Long cozinheiroId;
    private int senha;
    private int numFuncGerenciados;

    public Cozinheiro() {
    }

    public Cozinheiro(String nome, String cpf, String sexo, double salario, int senha, int numFuncGerenciados) {
        super(nome, cpf, sexo, salario);
        this.senha = senha;
        this.numFuncGerenciados = numFuncGerenciados;
        this.cozinheiroId = cozinheiroId;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getNumFuncGerenciados() {
        return numFuncGerenciados;
    }

    public void setNumFuncGerenciados(int numFuncGerenciados) {
        this.numFuncGerenciados = numFuncGerenciados;
    }

    public Long getCozinheiroId() {
        return cozinheiroId;
    }

    public void setCozinheiroId(Long cozinheiroId) {
        this.cozinheiroId = cozinheiroId;
    }
}
