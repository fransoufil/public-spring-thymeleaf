package com.franz.demospringmvc.dao;

import java.util.List;

import com.franz.demospringmvc.domain.Funcionario;

public interface FuncionarioDao {
	
	//adicionar uma lista de metodos referentes aos metodos que temos no abstractdao
			void save(Funcionario Funcionario);
			
			void update(Funcionario Funcionario);
			
			void delete(Long id);
			
			Funcionario findById(Long id);
			
			List<Funcionario> findAll();


}
