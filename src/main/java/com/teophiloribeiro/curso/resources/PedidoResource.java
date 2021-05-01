package com.teophiloribeiro.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teophiloribeiro.curso.domain.Pedido;
import com.teophiloribeiro.curso.services.PedidoService;

//CONTROLADOR REST

// Controlador Rest que vai responder pelo endpoint categorias
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired //para instanciar automaticamente
	private PedidoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
}
