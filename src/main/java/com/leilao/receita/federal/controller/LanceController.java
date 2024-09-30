package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.enums.EstadoDoLeilao;
import com.leilao.receita.federal.model.Lance;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.service.LanceService;
import com.leilao.receita.federal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{produtoId}")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping("/lances")
    public Lance createLance(@RequestBody Lance lance){
        return  lanceService.saveLance(lance);
    }

    @GetMapping("/lances")
    public List<Lance> getLancesByProdutoId(@PathVariable Long produtoId) {
        return lanceService.findLancesByProdutoId(produtoId);
    }
}