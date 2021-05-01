package com.teophiloribeiro.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teophiloribeiro.curso.domain.Pagamento;

//CAMADA DE DADOS

//Acessar o banco e fazer consultas na tabela Pagamento, utilizando o id (Integer) como identificador 
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
