package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.Cidade;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Cidade, utilizando o id (Integer) como identificador 
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
