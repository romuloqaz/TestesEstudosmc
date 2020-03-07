package com.ifpb.edu.cursomc.services;

import java.util.List;

import com.ifpb.edu.cursomc.domain.Estado;
import com.ifpb.edu.cursomc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public List<Estado> findAll() {
        return repo.findAllByOrderByNome();
    }
}