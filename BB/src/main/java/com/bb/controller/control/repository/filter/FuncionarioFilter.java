package com.bb.controller.control.repository.filter;

import java.io.Serializable;
import java.util.List;

import com.bb.models.Grupo;

public class FuncionarioFilter implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private List<Grupo>grupos;
	
	private int primeiroRegistro;
	private int qtdeRequistros;
	private String propriedadeOrdenacao;
	private boolean ascendente;
	
	
	
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
	public int getPrimeiroRegistro() {
		return primeiroRegistro;
	}
	public void setPrimeiroRegistro(int primeiroRegistro) {
		this.primeiroRegistro = primeiroRegistro;
	}
	public int getQtdeRequistros() {
		return qtdeRequistros;
	}
	public void setQtdeRequistros(int qtdeRequistros) {
		this.qtdeRequistros = qtdeRequistros;
	}
	public String getPropriedadeOrdenacao() {
		return propriedadeOrdenacao;
	}
	public void setPropriedadeOrdenacao(String propriedadeOrdenacao) {
		this.propriedadeOrdenacao = propriedadeOrdenacao;
	}
	public boolean isAscendente() {
		return ascendente;
	}
	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}
	
}
