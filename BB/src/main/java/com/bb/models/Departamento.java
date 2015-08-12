package com.bb.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long codigo;
	
	@NotNull @Size(max=30)
	@Column(length=30)
	private String gerente;
	
	@NotNull @Size(max=45)
	@Column(length=45)
	private String nome;
	
	
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
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
