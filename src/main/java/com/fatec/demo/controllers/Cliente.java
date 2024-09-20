package com.fatec.demo.controllers;

//Criação da classe Cliente
public class Cliente {
    private int id;
    private String nome;
 
    // Construtor padrão
    public Cliente() {
    }
 
    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
 
    // Getters e Setters
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
}