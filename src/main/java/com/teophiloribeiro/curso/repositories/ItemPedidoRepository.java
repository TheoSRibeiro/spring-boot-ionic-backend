package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.ItemPedido;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela ItemPedido, utilizando o id (Integer) como identificador 
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

}
