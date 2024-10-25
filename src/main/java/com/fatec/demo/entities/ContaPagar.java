// package com.fatec.demo.models;
package com.fatec.demo.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ContaPagar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate emissao;
    private LocalDate vencimento;

    @ManyToOne
    private Fornecedor fornecedor;

    private BigDecimal valor;

    // Getters e Setters e Construtor
    public ContaPagar() {
    }
 
    public ContaPagar(int id, String nome, LocalDate emissao, LocalDate vencimento, BigDecimal valor, Fornecedor fornecedor) {
        this.id = id;
        this.emissao = emissao;
        this.vencimento = vencimento;
        this.valor = valor;
        this.fornecedor = fornecedor;
    }
 
    // Getters e Setters
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public LocalDate getEmissao() {
        return emissao;
    }
 
    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }
 
    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }
 
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Fornecedor getFornecedor(){
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
    }
}
