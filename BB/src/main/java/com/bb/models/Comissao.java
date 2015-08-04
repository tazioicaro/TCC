package com.bb.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bb.models.Enumerators.TipoComissao;

@Entity
public class Comissao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer codigo;
	
	@Column(name="tipo_comissao")	
	private TipoComissao tipoComissao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public TipoComissao getTipoComissao() {
		return tipoComissao;
	}

	public void setTipoComissao(TipoComissao tipoComissao) {
		this.tipoComissao = tipoComissao;
	}
	
	
}
