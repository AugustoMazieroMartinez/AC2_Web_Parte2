package com.example.xyz_enterprise.Services;

import com.example.xyz_enterprise.Models.Curso;
import com.example.xyz_enterprise.Models.Professor;
import com.example.xyz_enterprise.Repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public List<Professor> listarProfessoresPorCurso(int cursoId) {
        return cursoRepository.findProfessoresByCurso(cursoId);
    }

    public Curso cadastrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
}