package com.bb.models;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Id;

/**
 * 
 * @author Tazio
 *Codigo Fiscal da Operaçãoo
 */

//@Named
public class CFOp implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long codigo;
	private String descricao;

	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
