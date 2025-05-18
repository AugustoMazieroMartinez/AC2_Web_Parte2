package com.example.xyz_enterprise.repositories;

import com.example.xyz_enterprise.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    List<Agenda> findByProfessorId(Integer professorId);
    List<Agenda> findByCursoId(Integer cursoId);
    @Query("SELECT a FROM Agenda a WHERE a.professor.id = :professorId AND " +
           "((a.dataInicio <= :dataFim AND a.dataFim >= :dataInicio))")
    List<Agenda> findProfessorLivre(Integer professorId, LocalDate dataInicio, LocalDate dataFim);
}
