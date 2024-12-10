package com.leilao.receita.federal.controller;

import com.leilao.receita.federal.enums.EstadoDoLeilao;
import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.ProdutosPorLeilao;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.service.ExportacaoService;
import com.leilao.receita.federal.service.FiltroService;
import com.leilao.receita.federal.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leilao")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @Autowired
    private FiltroService filtroService;

    @Autowired
    private ExportacaoService exportacaoService;

    @GetMapping("/{leilaoId}/exportar")
    public ResponseEntity<String> exportarDetalhesLeilao(@PathVariable Long leilaoId) {
        try {
            exportacaoService.exportarDetalhesLeilao(leilaoId);
            return ResponseEntity.ok("Arquivo .DET gerado com sucesso!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao gerar o arquivo .DET: " + e.getMessage());
        }
    }

    @GetMapping("/veiculos")
    public ResponseEntity<List<Veiculo>> getVeiculos(@RequestParam(required = false) Double lanceMin,
                                                     @RequestParam(required = false) Double lanceMax,
                                                     @RequestParam(required = false) String nomeProduto) {
        List<Veiculo> veiculos = filtroService.filtrarVeiculos(lanceMin, lanceMax, nomeProduto);
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/informaticas")
    public ResponseEntity<List<Informatica>> getInformaticas(@RequestParam(required = false) Double lanceMin,
                                                             @RequestParam(required = false) Double lanceMax,
                                                             @RequestParam(required = false) String nomeProduto) {
        List<Informatica> informaticas = filtroService.filtrarInformatica(lanceMin, lanceMax, nomeProduto);
        return ResponseEntity.ok(informaticas);
    }

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

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<Leilao> getDetalhesLeilao(@PathVariable Long id) {
        Leilao leilao = leilaoService.getDetalhesLeilao(id);
        return ResponseEntity.ok(leilao);
    }
}
