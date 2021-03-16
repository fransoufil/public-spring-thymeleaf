package com.franz.demospringmvc.dao;

import java.util.List;

import com.franz.demospringmvc.domain.Cargo;

public interface CargoDao {
	
	//adicionar uma lista de metodos referentes aos metodos que temos no abstractdao
		void save(Cargo cargo);
		
		void update(Cargo cargo);
		
		void delete(Long id);
		
		Cargo findById(Long id);
		
		List<Cargo> findAll();

}
