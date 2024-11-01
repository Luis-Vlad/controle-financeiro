package com.fatec.demo.controllers;

import com.fatec.demo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    // Busca todos os clientes pelo nome exato
    List<Cliente> findAllByNome(String nome);

    // Busca todos os clientes cujo nome contém a string especificada
    List<Cliente> findAllByNomeContaining(String nome);
}
