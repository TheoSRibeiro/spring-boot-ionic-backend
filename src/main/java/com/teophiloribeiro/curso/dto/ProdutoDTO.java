package com.teophiloribeiro.curso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.teophiloribeiro.curso.domain.Produto;
import com.teophiloribeiro.curso.services.validation.ClienteUpdate;

@ClienteUpdate
public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Peenchimento Obrigatório!")
	@Size(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres!")
	private String nome;
	
	private Double preco;
	
	public ProdutoDTO() {	
	}
	
	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	
	
}
