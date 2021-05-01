package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.Estado;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Estado, utilizando o id (Integer) como identificador 
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
