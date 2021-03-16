package com.franz.demospringmvc.dao;

import org.springframework.stereotype.Repository;

import com.franz.demospringmvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {
	
}
