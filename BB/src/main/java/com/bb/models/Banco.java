package com.bb.models;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Banco implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer codigo;
	
	
	@Column(name="cod_banco", nullable=false)
	private Integer codBanco;
	
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Integer agencia;
	
	@Column(nullable=false)
	private Integer conta;
	
	
	

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}	
	
	public Integer getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(Integer codBanco) {
		this.codBanco = codBanco;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Integer getConta() {
		return conta;
	}
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	
	
	@Transient
	public boolean isValido() {
		if(nome !=null && agencia !=null && conta !=null)
			return true;
		return false;
	}
	
	

}
