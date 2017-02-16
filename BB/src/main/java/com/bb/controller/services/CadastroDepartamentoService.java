package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Departamento;

public class CadastroDepartamentoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Departamentos repositorioDepartamentos;
	
	
	@Transactional
	public Departamento salvar ( Departamento departamento) throws NegocioException{
		
		if(repositorioDepartamentos.porNome(departamento.getNome())!=null){
			throw new NegocioException("Já existe um departamento com o nome: "+ departamento.getNome());
		}
		
		departamento = repositorioDepartamentos.guardar(departamento);
		
		return departamento;
	}
	

}
