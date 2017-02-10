package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Clientes;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Cliente;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes repositorioClientes;

	@Transactional
	public Cliente salvar(Cliente cliente) {

		Cliente usuarioExistenteNome = repositorioClientes.consultarNome(cliente.getNome());
		Cliente usuarioExistenteEmail = repositorioClientes.porEmail(cliente.getEmail());
		Cliente usuarioExistenteDoc = repositorioClientes.porDocIdentificacao(cliente.getDocumentoReceitaFederal());

		if (usuarioExistenteNome != null && usuarioExistenteNome.getNome().equals(cliente.getNome())) {
			throw new NegocioException("Já existe um usuário com o nome informado. ");
		}
		if (usuarioExistenteEmail != null && usuarioExistenteEmail.getDocumentoReceitaFederal().equals(cliente.getEmail())) {
			throw new NegocioException("Já existe um usuário com o e-mail informado. ");
		}
		if (usuarioExistenteDoc != null && usuarioExistenteDoc.getDocumentoReceitaFederal().equals(cliente.getDocumentoReceitaFederal())) {
			throw new NegocioException("Já existe um usuário do o Documento de Identificação informado");
		}

		cliente = this.repositorioClientes.guardar(cliente);
		return cliente;

	}

}
