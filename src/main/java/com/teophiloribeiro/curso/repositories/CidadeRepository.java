package com.teophiloribeiro.curso.repositories;

import java.util.List;

import com.teophiloribeiro.curso.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Cidade, utilizando o id (Integer) como identificador 
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

    @Transactional(readOnly=true)
	@Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
	public List<Cidade> findCidades(@Param("estadoId") Integer estado_id);
}
