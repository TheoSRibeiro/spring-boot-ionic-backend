package com.teophiloribeiro.curso.repositories;


import com.teophiloribeiro.curso.domain.Cliente;
import com.teophiloribeiro.curso.domain.Pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Pedido, utilizando o id (Integer) como identificador 
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
    @Transactional(readOnly=true)
    Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
}
