package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.bb.models.Unidade;

public class UnidadesMedidas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public Unidade porCodigo(Long codigo){		
		 return manager.find(Unidade.class, codigo);		
	}
	
	public List<Unidade> todas(){
		return manager.createQuery("from Unidade", Unidade.class).getResultList();
	}

}
