package com.bb.models;

import java.io.Serializable;
import java.sql.Date;

public class Agendamento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private Pedido pedido;
	private Cliente cliente;
	private String status;
	private Date dataSolicitacao;
	private Date dataSugerida;
	
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public Date getDataSugerida() {
		return dataSugerida;
	}
	public void setDataSugerida(Date dataSugerida) {
		this.dataSugerida = dataSugerida;
	}
	
	
	

}
