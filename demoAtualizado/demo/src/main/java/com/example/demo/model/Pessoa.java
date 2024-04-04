package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa {
    private String nome;
    @NotNull(message = "Campo cpf não pode ser nulo.")
    @Column(nullable = false)
    @Size(min = 11, max = 14)
    private String cpf;
    private String sexo;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
