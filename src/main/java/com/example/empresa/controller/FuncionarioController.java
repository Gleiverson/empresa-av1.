package com.exemplo.empresa.controller;

import com.exemplo.empresa.model.Funcionario;
import com.exemplo.empresa.model.Departamento;
import com.exemplo.empresa.repository.FuncionarioRepository;
import com.exemplo.empresa.repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioRestController {

    private final FuncionarioRepository funcRepo;
    private final DepartamentoRepository deptRepo;

    public FuncionarioRestController(FuncionarioRepository funcRepo, DepartamentoRepository deptRepo) {
        this.funcRepo = funcRepo;
        this.deptRepo = deptRepo;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Funcionario funcionario) {
        if (funcionario.getDepartamento() != null && funcionario.getDepartamento().getId() != null) {
            Departamento dept = deptRepo.findById(funcionario.getDepartamento().getId()).orElse(null);
            funcionario.setDepartamento(dept);
        }
        Funcionario saved = funcRepo.save(funcionario);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Funcionario> listar() {
        return funcRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
        return funcRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario f) {
        return funcRepo.findById(id).map(existing -> {
            existing.setNome(f.getNome());
            existing.setEmail(f.getEmail());
            existing.setDataAdmissao(f.getDataAdmissao());
            if (f.getDepartamento() != null && f.getDepartamento().getId() != null) {
                deptRepo.findById(f.getDepartamento().getId()).ifPresent(existing::setDepartamento);
            }
            funcRepo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return funcRepo.findById(id).map(existing -> {
            funcRepo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

