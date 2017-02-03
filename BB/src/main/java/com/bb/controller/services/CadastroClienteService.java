package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Clientes;
import com.bb.models.Cliente;

public class CadastroClienteService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Clientes clientes;
	
	
	public Cliente salvar (Cliente cliente){
		return clientes.guardar(cliente);   
		
		
	}

}
