package com.bb.controller.control.repository.filter;

import java.io.Serializable;
import java.util.List;

import com.bb.models.Grupo;

public class FuncionarioFilter implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private List<Grupo>grupos;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
	
	

}
