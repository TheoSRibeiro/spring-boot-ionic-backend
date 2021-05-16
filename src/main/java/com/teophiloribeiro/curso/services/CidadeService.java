package com.teophiloribeiro.curso.services;

import java.util.List;

import com.teophiloribeiro.curso.domain.Cidade;
import com.teophiloribeiro.curso.repositories.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}
