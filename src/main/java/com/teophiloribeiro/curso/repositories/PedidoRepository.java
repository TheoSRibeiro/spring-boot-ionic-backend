package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.Pedido;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Pedido, utilizando o id (Integer) como identificador 
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
