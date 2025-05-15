package com.example.xyz_enterprise.Controllers;

import com.example.xyz_enterprise.Models.Curso;
import com.example.xyz_enterprise.Models.Professor;
import com.example.xyz_enterprise.Services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}/professores")
    public List<Professor> listarProfessoresPorCurso(@PathVariable int id) {
        return cursoService.listarProfessoresPorCurso(id);
    }

    @PostMapping
    public Curso cadastrarCurso(@RequestBody Curso curso) {
        return cursoService.cadastrarCurso(curso);
    }
}