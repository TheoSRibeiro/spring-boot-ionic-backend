package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.Produto;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Produto, utilizando o id (Integer) como identificador 
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
