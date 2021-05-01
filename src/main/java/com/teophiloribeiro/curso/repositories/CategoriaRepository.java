package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.Categoria;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Categoria, utilizando o id (Integer) como identificador 
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
