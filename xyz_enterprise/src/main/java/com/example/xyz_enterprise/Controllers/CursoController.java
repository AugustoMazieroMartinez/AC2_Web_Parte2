package com.example.xyz_enterprise.controllers;

import com.example.xyz_enterprise.models.Curso;
import com.example.xyz_enterprise.services.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        return cursoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @PostMapping(consumes = "application/json")
    public Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> putById(@PathVariable Integer id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.putById(id, curso));
    }
}
