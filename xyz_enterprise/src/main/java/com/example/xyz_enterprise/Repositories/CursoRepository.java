package com.example.xyz_enterprise.Repositories;

import com.example.xyz_enterprise.Models.Curso;
import com.example.xyz_enterprise.Models.Professor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    List<Professor> findProfessoresByCurso(int cursoId);
}