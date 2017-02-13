package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.bb.controller.services.NegocioException;
import com.bb.models.Funcionario;

public class Funcionarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manage;
	
	
	public Funcionario porID(Long id){
		
		return manage.find(Funcionario.class, id);
	}
	
	public List<Funcionario> vendedores(){
		
		return manage.createQuery("from funcionario", Funcionario.class).getResultList();
		
	}
	
	
	public Funcionario porNome(String nome){
		
		Funcionario funcionario = null;
		
		try{
			funcionario = manage.createQuery("from Funcionario where lower(nome) =:nome", Funcionario.class)
			.setParameter("nome", nome.toLowerCase()).getSingleResult();
		}catch(NoResultException ne){			
			
		}
		
		return funcionario;
		
	}
	

}
