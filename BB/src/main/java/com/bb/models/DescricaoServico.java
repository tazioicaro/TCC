package com.bb.models;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;


//@Named
public class DescricaoServico implements Serializable {
	
		private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_ds")
	private Integer codigo;
	
	@Column(name="servico_codigo_s")
	@OneToMany
	private Servicos servicos;
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Servicos getServicos() {
		return servicos;
	}
	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}
	
	

}
