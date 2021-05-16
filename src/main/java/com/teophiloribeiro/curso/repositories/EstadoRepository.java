package com.teophiloribeiro.curso.repositories;

import java.util.List;

import com.teophiloribeiro.curso.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Estado, utilizando o id (Integer) como identificador 
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

    @Transactional(readOnly = true)
    public List<Estado> findAllByOrderByNome();
}
