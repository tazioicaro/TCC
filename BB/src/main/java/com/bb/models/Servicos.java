package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bb.models.Enumerators.StatusServico;
import com.bb.models.Enumerators.TipoComissao;

@Entity
public class Servicos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(nullable=false, length=25)
	private String nome;
	
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal preco;
	
	@Column(nullable=false, precision=10, scale=2)
	private Comissao comissao;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=20, name="tipo_comissao")
	private TipoComissao tipoComissao;
	
	@ManyToOne
	@JoinColumn(name="funcionario_codigo", nullable=false)
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="produto_codigo", nullable=false)
	private Produto produto;
	
	
	private CFOp cfOp;
	private String duracaoMaxima;
	private String detalhes;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=25, name="status_servico")
	private StatusServico statusServico;
	
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Comissao getComissao() {
		return comissao;
	}
	public void setComissao(Comissao comissao) {
		this.comissao = comissao;
	}
	public TipoComissao getTipoComissao() {
		return tipoComissao;
	}
	public void setTipoComissao(TipoComissao tipoComissao) {
		this.tipoComissao = tipoComissao;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public CFOp getCfOp() {
		return cfOp;
	}
	public void setCfOp(CFOp cfOp) {
		this.cfOp = cfOp;
	}
	public String getDuracaoMaxima() {
		return duracaoMaxima;
	}
	public void setDuracaoMaxima(String duracaoMaxima) {
		this.duracaoMaxima = duracaoMaxima;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public StatusServico getStatusServico() {
		return statusServico;
	}
	public void setStatusServico(StatusServico statusServico) {
		this.statusServico = statusServico;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Servicos other = (Servicos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
