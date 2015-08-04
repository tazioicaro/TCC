package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/** 
 * @author Tazio
 * Detalhe nota fiscal
 */

@Entity(name="dnf")
public class DNF implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType. AUTO)
	private Long codigo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_codigo")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable=false, name = "cnf_numero")
	private CNF cnf;
	
	@Column(name="qtde")
	private Integer quantidade;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_unitario")
	private BigDecimal vlrunitario;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_total")
	private BigDecimal vlrtotal;

	
	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CNF getCnf() {
		return cnf;
	}

	public void setCnf(CNF cnf) {
		this.cnf = cnf;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getVlrunitario() {
		return vlrunitario;
	}

	public void setVlrunitario(BigDecimal vlrunitario) {
		this.vlrunitario = vlrunitario;
	}

	public BigDecimal getVlrtotal() {
		return vlrtotal;
	}

	public void setVlrtotal(BigDecimal vlrtotal) {
		this.vlrtotal = vlrtotal;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DNF))
			return false;
		DNF dnf = (DNF) obj;
		if (getCodigo() != null && getCodigo().equals(dnf.getCodigo()))
			return true;
		if (getCodigo() == null
				&& getProduto() != null
				&& getProduto().getCodigo()
						.equals(dnf.getProduto().getCodigo()))
			return true;
		return false;
	}

	@Override
	public int hashCode() {

		if (getCodigo() != null) {
			return (int) (long) getCodigo();
		}
		return (int) (long) getProduto().getCodigo();
	}

}
