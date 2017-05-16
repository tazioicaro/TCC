package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.bb.models.Fornecedor;

public class FornecedorRepository  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	
	public Fornecedor porCodigo(Long codigo){		
		 return manager.find(Fornecedor.class, codigo);		
	}
	
	public List<Fornecedor> todos(){
		return manager.createQuery("from Fornecedor", Fornecedor.class).getResultList();
	}

}
