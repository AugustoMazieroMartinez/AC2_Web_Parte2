package com.example.xyz_enterprise.services;

import com.example.xyz_enterprise.models.Curso;
import com.example.xyz_enterprise.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public Curso putById(Integer id, Curso curso) {
        curso.setId(id);
        return cursoRepository.save(curso);
    }
}
