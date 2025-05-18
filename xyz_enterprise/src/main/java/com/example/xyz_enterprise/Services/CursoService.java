package com.example.xyz_enterprise.services;

import com.example.xyz_enterprise.models.Curso;
import java.util.List;
import java.util.Optional;

public interface CursoService {
    Optional<Curso> findById(Integer id);
    List<Curso> findAll();
    Curso save(Curso curso);
    void deleteById(Integer id);
    Curso putById(Integer id, Curso curso);
}
