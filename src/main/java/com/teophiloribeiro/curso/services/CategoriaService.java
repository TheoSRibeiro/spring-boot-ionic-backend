package com.teophiloribeiro.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teophiloribeiro.curso.domain.Categoria;
import com.teophiloribeiro.curso.repositories.CategoriaRepository;
import com.teophiloribeiro.curso.services.exceptions.ObjectNotFoundException;

//CAMADA DE SERVICO
//faz a consulta no repositorio

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); //garantir que o id vai ser atribuido pelo bd
		return repo.save(obj);
		
	}
	
}
