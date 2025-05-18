package com.example.xyz_enterprise.controllers;

import com.example.xyz_enterprise.models.Professor;
import com.example.xyz_enterprise.services.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id) {
        return professorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Professor> findAll() {
        return professorService.findAll();
    }

    @PostMapping
    public Professor save(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        professorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> putById(@PathVariable Integer id, @RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.putById(id, professor));
    }

    @GetMapping("/especializacao/{cursoId}")
    public List<Professor> findByEspecializacao(@PathVariable Integer cursoId) {
        return professorService.findByEspecializacao(cursoId);
    }
}
