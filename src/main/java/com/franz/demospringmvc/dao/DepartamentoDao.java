package com.franz.demospringmvc.dao;

import java.util.List;

import com.franz.demospringmvc.domain.Departamento;

public interface DepartamentoDao {
	
	//adicionar uma lista de metodos referentes aos metodos que temos no abstractdao
	void save(Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Long id);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();
	
	//apoś criado, falta transformar o DepartamentoDaoImpl em um Bean gerenciavel pelo Spring
}
