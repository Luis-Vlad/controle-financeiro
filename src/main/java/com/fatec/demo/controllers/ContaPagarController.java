package com.fatec.demo.controllers;

import com.fatec.demo.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

//http://localhost:8080/api/contas-pagar

@RestController
@RequestMapping("/api/contas-pagar")
public class ContaPagarController {

    private final ContaPagarRepository contaPagarRepository;
    private final FornecedorRepository fornecedor;

    public ContaPagarController(ContaPagarRepository contaPagarRepository, FornecedorRepository fornecedor) {
        this.contaPagarRepository = contaPagarRepository;
        this.fornecedor = fornecedor;
    }

    @PostMapping("/criar")
    public ResponseEntity<ContaPagar> criarContaPagar(@RequestBody ContaPagar contaPagar) {
        
        if (contaPagar.getEmissao().isAfter(contaPagar.getVencimento())) {
            throw new IllegalArgumentException("A data de emissão não pode ser posterior à data de vencimento.");
        }
        if (contaPagar.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da conta a pagar deve ser positivo.");
        }
        if (fornecedor.findById(contaPagar.getFornecedor().getId()).isEmpty()) {
            throw new IllegalArgumentException("Fornecedor não encontrado. Por favor, cadastre o fornecedor antes de associá-lo a uma conta a pagar.");
        }
        

        ContaPagar saved = contaPagarRepository.save(contaPagar);
        return ResponseEntity.ok(saved);

        
    }

    @GetMapping("/listar")
    public List<ContaPagar> listarContasPagar() {
        return contaPagarRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ContaPagar> obterContaPagar(@PathVariable int id) {
        return contaPagarRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ContaPagar> atualizarContaPagar(@PathVariable int id, @RequestBody ContaPagar contaPagarAtualizada) {
        return contaPagarRepository.findById(id)
                .map(contaPagar -> {
                    contaPagar.setEmissao(contaPagarAtualizada.getEmissao());
                    contaPagar.setVencimento(contaPagarAtualizada.getVencimento());
                    contaPagar.setFornecedor(contaPagarAtualizada.getFornecedor());
                    contaPagar.setValor(contaPagarAtualizada.getValor());
                    return ResponseEntity.ok(contaPagarRepository.save(contaPagar));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarContaPagar(@PathVariable int id) {
        if (!contaPagarRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contaPagarRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
