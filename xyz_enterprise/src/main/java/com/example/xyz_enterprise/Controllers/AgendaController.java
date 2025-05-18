package com.example.xyz_enterprise.controllers;

import com.example.xyz_enterprise.models.Agenda;
import com.example.xyz_enterprise.services.AgendaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> findById(@PathVariable Integer id) {
        return agendaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Agenda> findAll() {
        return agendaService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Agenda agenda) {
        try {
            Agenda saved = agendaService.save(agenda);
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        agendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putById(@PathVariable Integer id, @RequestBody Agenda agenda) {
        try {
            Agenda updated = agendaService.putById(id, agenda);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/professor/{professorId}")
    public List<Agenda> findByProfessorId(@PathVariable Integer professorId) {
        return agendaService.findByProfessorId(professorId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Agenda> findByCursoId(@PathVariable Integer cursoId) {
        return agendaService.findByCursoId(cursoId);
    }

    @GetMapping("/professor-livre/{professorId}")
    public List<Agenda> findProfessorLivre(
            @PathVariable Integer professorId,
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        return agendaService.findProfessorLivre(professorId, dataInicio, dataFim);
    }
}
