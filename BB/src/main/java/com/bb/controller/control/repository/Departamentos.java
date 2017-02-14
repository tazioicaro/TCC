package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.bb.models.Departamento;


public class Departamentos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public List<Departamento> porDepartamento(){
		
		
		return this.manager.createQuery("from Departamento", Departamento.class).getResultList();
	}
	
	
}
