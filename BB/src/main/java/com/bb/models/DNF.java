package com.bb.models;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
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

//@Named("descricao_nfe")
public class DNF implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType. AUTO)
	private Long codigo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produtos_codigo_pro")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nfe_numero")
	private CNF cnf;
	
	@Column(name="qtde")
	private Integer quantidade;
	
	
	private Double vlrunitario;
	private Double vlrtotal;

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

	public Double getVlrunitario() {
		return vlrunitario;
	}

	public void setVlrunitario(Double vlrunitario) {
		this.vlrunitario = vlrunitario;
	}

	public Double getVlrtotal() {
		return vlrtotal;
	}

	public void setVlrtotal(Double vlrtotal) {
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
