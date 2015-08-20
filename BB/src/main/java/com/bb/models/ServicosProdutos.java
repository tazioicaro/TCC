package com.bb.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name="servicos_e_Produtos")
@Table
public class ServicosProdutos {
		
    @EmbeddedId
	private ServicosProdutosId codigo;
    
    
	
	private String consumo;
	private Integer qtde;
	
	
	
	public String getConsumo() {
		return consumo;
	}
	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public ServicosProdutosId getCodigo() {
		return codigo;
	}
	public void setCodigo(ServicosProdutosId codigo) {
		this.codigo = codigo;
	}
	
	
			

}
