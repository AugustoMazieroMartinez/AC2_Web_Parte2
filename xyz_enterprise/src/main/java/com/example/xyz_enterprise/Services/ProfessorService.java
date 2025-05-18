package com.example.xyz_enterprise.services;

import com.example.xyz_enterprise.models.Professor;
import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    Optional<Professor> findById(Integer id);
    List<Professor> findAll();
    Professor save(Professor professor);
    void deleteById(Integer id);
    Professor putById(Integer id, Professor professor);
    List<Professor> findByEspecializacao(Integer cursoId);
}
