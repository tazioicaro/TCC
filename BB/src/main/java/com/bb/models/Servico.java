package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.bb.models.Enumerators.StatusServico;

//Pedido
@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(nullable=false, length=25)
	private String nome;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_servico")
	private BigDecimal valor;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_desconto")
	private BigDecimal valorDesconto;
	
	@ManyToOne
	@JoinColumn(name="comissao_codigo", nullable=false)
	private Comissao comissao;
	
	//@Enumerated(EnumType.STRING)
	//@Column(nullable=false, length=20, name="tipo_comissao")
	//private TipoComissao tipoComissao;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="vendedor_codigo", nullable=false)
	private Funcionario funcionario;
	
	
    @OneToMany(mappedBy="servico")     
	private List<ServicosProdutos> servicosProdutosList;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cfop_codigo", nullable=false)
	private CFOp cfOp;
	
	@Column(nullable=false, name="duracao_maxima")
	@Temporal(TemporalType.TIME)
	private Date duracaoMaxima;
	
	@Column(name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name="data_conclusao")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataConclusao;
	
	@Column(length=150)
	private String detalhes;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=25, name="status_servico")
	private StatusServico statusServico;
	
	@ManyToOne
	@JoinColumn(name="dservico_codigo")
	private DescricaoServico servicos;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="especialidade_codigo", nullable=false )
	private Especialidade especialidade;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cliente_codigo", nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="forma_pagamento")
	private TipoPagamento formaPagamento;
	
	
	
	//G&S
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setServicosProdutosList(List<ServicosProdutos> servicosProdutosList) {
		this.servicosProdutosList = servicosProdutosList;
	}
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
		return valor;
	}
	public void setPreco(BigDecimal preco) {
		this.valor = preco;
	}
	public Comissao getComissao() {
		return comissao;
	}
	public void setComissao(Comissao comissao) {
		this.comissao = comissao;
	}
	//public TipoComissao getTipoComissao() {
	//	return tipoComissao;
	//}
	//public void setTipoComissao(TipoComissao tipoComissao) {
	//	this.tipoComissao = tipoComissao;
	//}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public CFOp getCfOp() {
		return cfOp;
	}
	public void setCfOp(CFOp cfOp) {
		this.cfOp = cfOp;
	}
	public Date getDuracaoMaxima() {
		return duracaoMaxima;
	}
	public void setDuracaoMaxima(Date duracaoMaxima) {
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
			
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public List<ServicosProdutos> getServicosProdutosList() {
		return servicosProdutosList;
	}
	public void setProduto(List<ServicosProdutos> servicosProdutosList) {
		this.servicosProdutosList = servicosProdutosList;
	}
	
	public DescricaoServico getServicos() {
		return servicos;
	}
	public void setServicos(DescricaoServico servicos) {
		this.servicos = servicos;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	

	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public TipoPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(TipoPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
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
		Servico other = (Servico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	

}
