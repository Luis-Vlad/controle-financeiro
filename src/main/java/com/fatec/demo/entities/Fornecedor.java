package com.fatec.demo.entities;

// import javax.persistence

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

import java.util.List;

import org.springframework.data.annotation.Id;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    // Relacionamento com Contas a Pagar
    @OneToMany(mappedBy = "fornecedor")
    private List<ContaPagar> contasPagar;

    // Construtor padrão
    public Fornecedor() {}

    public Fornecedor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

