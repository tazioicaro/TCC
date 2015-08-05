package com.bb.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bb.models.Enumerators.StatusAgendamento;

@Entity
public class Agendamento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer codigo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="pedido_codigo")
	private Pedido pedido;
	
	@Column(name="cliente_codigo")
	private Cliente cliente;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=25, name="status_agendamento")
	private StatusAgendamento status;
	
	@Column(name="data_solicitacao")
	private Date dataSolicitacao;
	
	@Column(name="data_sugerida")
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
	public StatusAgendamento getStatus() {
		return status;
	}
	public void setStatus(StatusAgendamento status) {
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
		Agendamento other = (Agendamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
