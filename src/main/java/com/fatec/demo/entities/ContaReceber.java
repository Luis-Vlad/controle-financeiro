package com.fatec.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ContaReceber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate emissao;
    private LocalDate vencimento;

    @ManyToOne
    private Cliente cliente;

    private BigDecimal valor;

    // Getters e Setters e Construtor
    public ContaReceber() {
    }
 
    public ContaReceber(int id, LocalDate emissao, LocalDate vencimento, BigDecimal valor, Cliente cliente) {
        this.id = id;
        this.emissao = emissao;
        this.vencimento = vencimento;
        this.valor = valor;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
