package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.model.EntidadeFinanceira;
import com.leilao.receita.federal.service.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entidade")
public class EntidadeFinanceiraController {

    @Autowired
    private EntidadeService entidadeService;

    @GetMapping
    public List<EntidadeFinanceira> getAllEntidade() {
        return entidadeService.getAllEntidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadeFinanceira> getEntidadeById(@PathVariable Long id) {
        Optional<EntidadeFinanceira> entidade = entidadeService.getEntidadeById(id);
        return entidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntidadeFinanceira> createEntidade(@RequestBody EntidadeFinanceira entidadeFinanceira) {
        EntidadeFinanceira savedEntidade = entidadeService.createEntidade(entidadeFinanceira);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadeFinanceira> updateEntidade(@PathVariable Long id, @RequestBody EntidadeFinanceira entidadeFinanceira) {
        EntidadeFinanceira updateEntidade = entidadeService.updateEntidade(id, entidadeFinanceira);
        if (entidadeFinanceira == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entidadeFinanceira);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntidade(@PathVariable Long id) {
        if (!entidadeService.deleteEntidade(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
