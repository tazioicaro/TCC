package com.bb.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="servicos_e_Produtos")
@Table
public class ServicosProdutos implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue	
	private Long codigo;
    
    
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produto_codigo")
	@NotFound(action = NotFoundAction.IGNORE)
    private Produto produto;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="servico_codigo")
    @NotFound(action = NotFoundAction.IGNORE)
    private Servico servico;  
    
	
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
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
			

}
