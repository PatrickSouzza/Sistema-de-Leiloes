package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.model.Lances;
import com.leilao.receita.federal.service.LanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private LanceService lanceService; // Serviço para acessar os lances

    @GetMapping("/{usuarioId}/lances")
    public List<Lances> getLancesByUsuarioId(@PathVariable Long usuarioId) {
        return lanceService.findLancesByUsuarioId(usuarioId); // Método que busca os lances por ID do usuário
    }
}
