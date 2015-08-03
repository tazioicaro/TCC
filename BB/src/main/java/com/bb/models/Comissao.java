package com.bb.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bb.models.Enumerators.TipoComissao;

public class Comissao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_c")
	private Integer codigo;
	
	@Column(name="tipo_comissao_codigo_tc")
	@OneToMany
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
