package com.bb.models;

import java.io.Serializable;

public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String gerente;
	private String nome;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
