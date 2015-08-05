package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Adiantamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_adiantado")
	private BigDecimal valorAdiantado;
	
	@ManyToOne
	@JoinColumn(name="funcionario_codigo")
	private Funcionario funcionario;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValorAdiantado() {
		return valorAdiantado;
	}
	public void setValorAdiantado(BigDecimal valorAdiantado) {
		this.valorAdiantado = valorAdiantado;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
	
	

}
