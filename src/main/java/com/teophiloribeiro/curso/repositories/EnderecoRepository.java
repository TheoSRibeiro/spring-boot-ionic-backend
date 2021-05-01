package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.Endereco;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Endereco, utilizando o id (Integer) como identificador 
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
