package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.bb.models.Enumerators.TipoComissao;

@Entity
public class Comissao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigo;
	
	//@NotBlank
	//@Enumerated(EnumType.STRING)
	@Column(name="tipo_comissao", length=25)	
	private String tipoComissao;
	
	@Column(name="porcentagem_comissao")
	private BigDecimal valorComissao;
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipoComissao() {
		return tipoComissao;
	}

	public void setTipoComissao(String tipoComissao) {
		this.tipoComissao = tipoComissao;
	}

	public BigDecimal getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}
	
	
}
