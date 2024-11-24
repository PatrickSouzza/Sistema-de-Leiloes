package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.model.Lance;
import com.leilao.receita.federal.service.LanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lances")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping
    public ResponseEntity<String> createLance(@RequestBody Lance lance) {
        try {
            Lance savedLance = lanceService.saveLance(lance);
            return ResponseEntity.status(HttpStatus.CREATED).body("Lance registrado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Lance>> listarLancesPorUsuario(@PathVariable Long usuarioId) {
        List<Lance> lances = lanceService.getLancesByUsuarioId(usuarioId);
        return ResponseEntity.ok(lances);
    }

    @GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<Lance>> getLancesByVeiculoId(@PathVariable Long veiculoId) {
        List<Lance> lances = lanceService.getLancesByVeiculoId(veiculoId);
        return ResponseEntity.ok(lances);
    }

    @GetMapping("/informatica/{informaticaId}")
    public ResponseEntity<List<Lance>> getLancesByInformaticaId(@PathVariable Long informaticaId) {
        List<Lance> lances = lanceService.getLancesByInformaticaId(informaticaId);
        return ResponseEntity.ok(lances);
    }
}
