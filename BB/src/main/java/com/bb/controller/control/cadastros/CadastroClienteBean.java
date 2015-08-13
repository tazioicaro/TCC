package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.bb.models.Cliente;
import com.bb.models.Endereco;
import com.bb.models.Servicos;

@Named
@SessionScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private  Cliente cliente;
	private Endereco endereco;
	private Servicos servicos;
	private List<Endereco> enderecos;
	
	
	
	
	
	public CadastroClienteBean() {
		enderecos = new ArrayList<Endereco>();
		cliente = new Cliente();
		endereco = new Endereco();
		servicos = new Servicos();
		
		
		enderecos.add(endereco);		
		cliente.setEnderecos(enderecos);
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
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Servicos getServicos() {
		return servicos;
	}


}
