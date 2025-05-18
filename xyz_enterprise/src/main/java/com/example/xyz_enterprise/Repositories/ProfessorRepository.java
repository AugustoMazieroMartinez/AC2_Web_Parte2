package com.example.xyz_enterprise.repositories;

import com.example.xyz_enterprise.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    @Query("SELECT p FROM Professor p JOIN p.especializacoes c WHERE c.id = :cursoId")
    List<Professor> findByEspecializacao(Integer cursoId);
}
