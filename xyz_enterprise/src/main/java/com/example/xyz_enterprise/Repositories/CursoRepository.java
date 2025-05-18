package com.example.xyz_enterprise.repositories;

import com.example.xyz_enterprise.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    // Métodos padrão do JpaRepository já cobrem os requisitos
}
