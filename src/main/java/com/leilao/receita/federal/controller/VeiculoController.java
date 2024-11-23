package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        List<Veiculo> veiculos = veiculoService.getAllVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.getVeiculoById(id);
        return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo savedVeiculo = veiculoService.createVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVeiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo updatedVeiculo = veiculoService.updateVeiculo(id, veiculo);
        return updatedVeiculo != null ? ResponseEntity.ok(updatedVeiculo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
        boolean deleted = veiculoService.deleteVeiculo(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/leilao")
    public ResponseEntity<Veiculo> updateLeilaoId(@PathVariable Long id, @RequestBody Leilao leilao) {
        Veiculo updatedVeiculo = veiculoService.updateLeilaoId(id, leilao);
        return updatedVeiculo != null ? ResponseEntity.ok(updatedVeiculo) : ResponseEntity.notFound().build();
    }

}

