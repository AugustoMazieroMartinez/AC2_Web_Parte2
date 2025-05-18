package com.example.xyz_enterprise.services;

import com.example.xyz_enterprise.models.Professor;
import com.example.xyz_enterprise.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Optional<Professor> findById(Integer id) {
        return professorRepository.findById(id);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }

    @Override
    public Professor putById(Integer id, Professor professor) {
        professor.setId(id);
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> findByEspecializacao(Integer cursoId) {
        return professorRepository.findByEspecializacao(cursoId);
    }
}
