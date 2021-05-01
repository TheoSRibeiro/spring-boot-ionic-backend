package com.teophiloribeiro.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teophiloribeiro.curso.domain.Cliente;
import com.teophiloribeiro.curso.repositories.ClienteRepository;
import com.teophiloribeiro.curso.services.exceptions.ObjectNotFoundException;

//CAMADA DE SERVICO
//faz a consulta no repositorio

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
