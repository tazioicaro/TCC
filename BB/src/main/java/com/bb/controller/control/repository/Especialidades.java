package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.bb.models.Especialidade;

public class Especialidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public List<Especialidade> raizes(){
		
		return manager.createQuery("from Especialidade", Especialidade.class).getResultList();
		
	}
}
