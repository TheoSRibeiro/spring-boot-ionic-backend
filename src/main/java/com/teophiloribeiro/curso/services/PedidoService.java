package com.teophiloribeiro.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teophiloribeiro.curso.domain.Pedido;
import com.teophiloribeiro.curso.repositories.PedidoRepository;
import com.teophiloribeiro.curso.services.exceptions.ObjectNotFoundException;

//CAMADA DE SERVICO
//faz a consulta no repositorio

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
