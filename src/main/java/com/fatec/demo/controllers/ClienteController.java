package com.fatec.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.fatec.demo.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

//POST => http://localhost:8080/clientes/criar
//GET => http://localhost:8080/clientes/listar
//PUT => http://localhost:8080/clientes/atualizar/{id}
//DELETE => http://localhost:8080/clientes/deletar/{id}
 
@RestController
@RequestMapping("/clientes")
public class ClienteController {
 
    private List<Cliente> clientes = new ArrayList<>();
    private Long proximoIdId = (long) 1;
 
    // Create (POST)
    @PostMapping("/criar")
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        cliente.setId(proximoIdId);
        proximoIdId++;
        clientes.add(cliente);
        return cliente;
    }
 
    // Read (GET)
    @GetMapping("/listar")
    public List<Cliente> getClientes() {
        return clientes;
    }
 
 
    // Update (PUT)
    @PutMapping("/atualizar/{id}")
    public Cliente atualizaCliente(@PathVariable int id, @RequestBody Cliente clienteAtualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNome(clienteAtualizado.getNome());
                return cliente;
            }
        }
        return null;
    }
 
    // Delete (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deleteCliente(@PathVariable int id ) {
        clientes.removeIf(cliente -> cliente.getId() == id);
        return "Cliente com id " + id + " foi removido.";
    }
}