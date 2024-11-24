package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.enums.EstadoDoLeilao;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.ProdutosPorLeilao;
import com.leilao.receita.federal.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leilao")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @GetMapping("/{leilaoId}/produtos")
    public ResponseEntity<ProdutosPorLeilao> getProdutosPorLeilao(@PathVariable Long leilaoId) {
        ProdutosPorLeilao response = leilaoService.getProdutosPorLeilao(leilaoId);
        return (response.getVeiculos().isEmpty() && response.getInformatica().isEmpty())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

    @GetMapping("/orderByDate")
    public ResponseEntity<List<Leilao>> listarLeiloesOrdenados(
            @RequestParam(defaultValue = "true") boolean ascending) {
        List<Leilao> leiloes = leilaoService.getAllLeiloesOrdered(ascending);
        return ResponseEntity.ok(leiloes);
    }

    @GetMapping
    public List<Leilao> getAllLeiloes() {
        return leilaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leilao> getLeilaoById(@PathVariable Long id) {
        Optional<Leilao> leilao = leilaoService.findById(id);
        return leilao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Leilao createLeilao(@RequestBody Leilao leilao) {
        leilao.setEstadoDoLeilao(EstadoDoLeilao.EmAberto);
        return leilaoService.save(leilao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leilao> updateLeilao(@PathVariable Long id, @RequestBody Leilao leilao) {
        Optional<Leilao> existingLeilao = leilaoService.findById(id);
        if (existingLeilao.isPresent()) {
            leilao.setId(id);
            return ResponseEntity.ok(leilaoService.save(leilao));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeilao(@PathVariable Long id) {
        if (leilaoService.findById(id).isPresent()) {
            leilaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
