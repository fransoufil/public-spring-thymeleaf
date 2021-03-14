package com.franz.demospringmvc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long>{
	
	//a classe somente tem id e nome, entao implementa apenas nome
	//pq o id vai ser herdado de AbstractEntity
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	//anota com mapped por que a relação é bidirecional, então deve definir lado forte e fraco
	//forte é o que contem a chave estrangeira, departamento é o lado forte e cargo o lado fraco
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
}
