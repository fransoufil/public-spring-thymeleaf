package com.franz.demospringmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class AbstractDao<T, PK extends Serializable> {
	
	//o T representa entidade, pode ser cargo, departamento ou funcionario
	// o PK tipo referente ao tio de chave primaria long integer ou qualquer outro tipo

	@SuppressWarnings("unchecked")
	//atribuir à varialvel entityClass qual o tipo da entidade que a operação que vem de um DAO especifico (cargoDao, funcionarioDao, categoriaDao)
	//está passando para AbstractDao
	private final Class<T> entityClass = 
			(Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@PersistenceContext
	//entityManager da JPA injetado a partir da Persistence Content
	private EntityManager entityManager;

	//se vc tem lá em Cargo a necessidade de fazer uma consulta que abstractDao não fornece
		// pode utilizar o metodo getEntityManager para ter acesso aos recursos da JPA para essa consulta
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	//nas transações abaixo não há a implementação de commit, close p.e. pois sera passada para o framework
	public void save(T entity) { 

		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		
		entityManager.merge(entity);
	}
	
	public void delete(PK id) {
		
		entityManager.remove(entityManager.getReference(entityClass, id));
	}
	
	public T findById(PK id) {
		
		return entityManager.find(entityClass, id);
	}
	
	public List<T> findAll() {
		
		return entityManager
				//abaixo se entityClass for cargo, fica from Cargo etc
				.createQuery("from " + entityClass.getSimpleName(), entityClass)
				.getResultList();
	}	
	
	//o metodo abaixo é protegido para que somente até o nível das classes que herdem AbstractDao a acessem
	//facilita para criar vários tipos de consultas, há a String jpql que será, como parametro, a query
	//e depois há a lista de params que são os valores da query
	//esse retorna apenas uma lista mas pode ser criado um segundo metodo que retorna um unico obj
	protected List<T> createQuery(String jpql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
		    query.setParameter(i+1, params[i]);
        }
    	return query.getResultList();
	}
}