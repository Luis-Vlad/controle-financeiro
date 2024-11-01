package com.fatec.demo.controllers;

import com.fatec.demo.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

//http://localhost:8080/api/contas-receber

@RestController
@RequestMapping("/api/contas-receber")
public class ContaReceberController {

    private final ContaReceberRepository contaReceberRepository;
    private final ClienteRepository cliente;

    public ContaReceberController(ContaReceberRepository contaReceberRepository, ClienteRepository cliente) {
        this.contaReceberRepository = contaReceberRepository;
        this.cliente = cliente;
    }

    @PostMapping("/criar")
    public ResponseEntity<ContaReceber> criarContaReceber(@RequestBody ContaReceber contaReceber) {
        
        if (contaReceber.getEmissao().isAfter(contaReceber.getVencimento())) {
            throw new IllegalArgumentException("A data de emissão não pode ser posterior à data de vencimento.");
        }
        if (contaReceber.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da conta a receber deve ser positivo.");
        }
        if (cliente.findById(contaReceber.getCliente().getId()).isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado. Por favor, cadastre o cliente antes de associá-lo a uma conta a receber.");
        }

        ContaReceber saved = contaReceberRepository.save(contaReceber);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/listar")
    public List<ContaReceber> listarContasReceber() {
        return contaReceberRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ContaReceber> obterContaReceber(@PathVariable int id) {
        return contaReceberRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ContaReceber> atualizarContaReceber(@PathVariable int id, @RequestBody ContaReceber contaReceberAtualizada) {
        return contaReceberRepository.findById(id)
                .map(contaReceber -> {
                    contaReceber.setEmissao(contaReceberAtualizada.getEmissao());
                    contaReceber.setVencimento(contaReceberAtualizada.getVencimento());
                    contaReceber.setCliente(contaReceberAtualizada.getCliente());
                    contaReceber.setValor(contaReceberAtualizada.getValor());
                    return ResponseEntity.ok(contaReceberRepository.save(contaReceber));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarContaReceber(@PathVariable int id) {
        if (!contaReceberRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contaReceberRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
