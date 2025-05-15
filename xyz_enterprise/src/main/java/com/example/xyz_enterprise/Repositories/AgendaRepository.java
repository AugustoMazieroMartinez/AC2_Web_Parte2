package com.example.xyz_enterprise.Repositories;

import com.example.xyz_enterprise.Models.Agenda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

    List<Agenda> findAgendasByProfessor(int professorId);
}