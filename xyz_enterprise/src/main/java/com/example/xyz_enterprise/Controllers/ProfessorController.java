package com.example.xyz_enterprise.Controllers;

import com.example.xyz_enterprise.Models.Professor;
import com.example.xyz_enterprise.Models.Agenda;
import com.example.xyz_enterprise.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listarProfessores() {
        return professorService.listarTodos();
    }

    @GetMapping("/{id}/agendas")
    public List<Agenda> listarAgendasPorProfessor(@PathVariable int id) {
        return professorService.listarAgendasPorProfessor(id);
    }

    @PostMapping
    public Professor cadastrarProfessor(@RequestBody Professor professor) {
        return professorService.cadastrarProfessor(professor);
    }
}