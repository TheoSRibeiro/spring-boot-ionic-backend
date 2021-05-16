package com.teophiloribeiro.curso.services;

import java.util.List;

import com.teophiloribeiro.curso.domain.Estado;
import com.teophiloribeiro.curso.repositories.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository repo;

    public List<Estado> findAll(){
        return repo.findAllByOrderByNome();
    }
}
