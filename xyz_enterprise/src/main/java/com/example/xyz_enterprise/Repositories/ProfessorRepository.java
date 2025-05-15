package com.example.xyz_enterprise.Repositories;

import com.example.xyz_enterprise.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}