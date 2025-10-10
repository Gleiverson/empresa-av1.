package com.exemplo.empresa.controller;

import com.exemplo.empresa.model.Departamento;
import com.exemplo.empresa.repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoRestController {

    private final DepartamentoRepository repo;

    public DepartamentoRestController(DepartamentoRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Departamento criar(@RequestBody Departamento departamento) {
        return repo.save(departamento);
    }

    @GetMapping
    public List<Departamento> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizar(@PathVariable Long id, @RequestBody Departamento dept) {
        return repo.findById(id).map(existing -> {
            existing.setNome(dept.getNome());
            existing.setLocalizacao(dept.getLocalizacao());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return repo.findById(id).map(existing -> {
            repo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

