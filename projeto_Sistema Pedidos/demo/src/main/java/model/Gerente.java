package model;

import jakarta.persistence.Entity;

@Entity
public class Gerente extends Cozinheiro {
    private int senha;
    private int numFuncGerenciados;

    public Gerente() {
    }

    public Gerente(String nome, String cpf, String idade, double salario, int senha, int numFuncGerenciados) {
        super(nome, cpf, idade, salario);
        this.senha = senha;
        this.numFuncGerenciados = numFuncGerenciados;
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
}

