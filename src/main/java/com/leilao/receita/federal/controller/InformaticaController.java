package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.service.InformaticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/informatica")
public class InformaticaController {

    @Autowired
    private InformaticaService informaticaService;

    @GetMapping
    public ResponseEntity<List<Informatica>> getAllInformatica() {
        List<Informatica> informaticas = informaticaService.getAllInformatica();
        return ResponseEntity.ok(informaticas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informatica> getInformaticaById(@PathVariable Long id) {
        Optional<Informatica> informatica = informaticaService.getInformaticaById(id);
        return informatica.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Informatica> createInformatica(@RequestBody Informatica informatica) {
        Informatica savedInformatica = informaticaService.createInformatica(informatica);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInformatica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Informatica> updateInformatica(@PathVariable Long id, @RequestBody Informatica informatica) {
        Informatica updatedInformatica = informaticaService.updateInformatica(id, informatica);
        return updatedInformatica != null ? ResponseEntity.ok(updatedInformatica) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformatica(@PathVariable Long id) {
        boolean deleted = informaticaService.deleteInformatica(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/leilao")
    public ResponseEntity<Informatica> updateLeilaoId(@PathVariable Long id, @RequestBody Leilao leilao) {
        Informatica updatedInformatica = informaticaService.updateLeilaoId(id, leilao);
        return updatedInformatica != null ? ResponseEntity.ok(updatedInformatica) : ResponseEntity.notFound().build();
    }
}
