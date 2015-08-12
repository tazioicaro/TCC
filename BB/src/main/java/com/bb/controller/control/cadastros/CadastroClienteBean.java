package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.bb.models.Cliente;
import com.bb.models.Endereco;

@Named
@SessionScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private  Cliente cliente;
	private Endereco endereco;
	private List<Endereco> enderecos;
	
	
	
	
	
	public CadastroClienteBean() {
		
		cliente = new Cliente();
		endereco = new Endereco();
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	

}
