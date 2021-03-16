package com.franz.demospringmvc.dao;

import org.springframework.stereotype.Repository;

import com.franz.demospringmvc.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao{

}
