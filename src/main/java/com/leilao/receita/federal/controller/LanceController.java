package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.model.Lances;
import com.leilao.receita.federal.service.LanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lances")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping
    public ResponseEntity<Lances> createLance(@RequestBody Lances lance) {
        Lances savedLance = lanceService.saveLance(lance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLance);
    }
}
