package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;


import com.bb.controller.control.repository.Clientes;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Cliente;

public class CadastroClienteService implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	@Transactional
	public Cliente salvar (Cliente cliente){
		
		Cliente usuarioExistenteNome = clientes.consultarNome(cliente.getNome());
		Cliente usuatioExistenteEmail = clientes.porEmail(cliente.getEmail());
		Cliente usuarioExistenteDoc = clientes.porDocIdentificacao(cliente.getDocumentoReceitaFederal());
		
		if(usuarioExistenteNome !=null && usuarioExistenteNome.equals(cliente.getNome())){
			throw new NegocioException("Já existe um usuário com o nome informado. ");
		}
		
		
		cliente = this.clientes.guardar(cliente);
		return cliente;   
		
		
	}

}
