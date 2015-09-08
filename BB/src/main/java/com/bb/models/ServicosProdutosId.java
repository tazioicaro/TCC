package com.bb.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class ServicosProdutosId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)	
	private Produto produto;
	
	@ManyToOne(fetch=FetchType.LAZY)	
	private Servico servicos;
	
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Servico getServicos() {
		return servicos;
	}
	public void setServicos(Servico servicos) {
		this.servicos = servicos;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result
				+ ((servicos == null) ? 0 : servicos.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicosProdutosId other = (ServicosProdutosId) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (servicos == null) {
			if (other.servicos != null)
				return false;
		} else if (!servicos.equals(other.servicos))
			return false;
		return true;
	}
	
	
	

		
	
	

}
	
	
	
	
	


