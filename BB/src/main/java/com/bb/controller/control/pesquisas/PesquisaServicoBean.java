package com.bb.controller.control.pesquisas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Servicos;
import com.bb.controller.control.repository.filter.ServicoFilter;
import com.bb.models.Pedido;
import com.bb.models.Enumerators.StatusPedido;

@Named
@ViewScoped
public class PesquisaServicoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Servicos pedidos;

	private List<Pedido> pedidosFiltrados;
	private ServicoFilter filtro;

	public PesquisaServicoBean() {
		setPedidosFiltrados(new ArrayList<Pedido>());
		filtro = new ServicoFilter();

	}

	public void pesquisar() {
		pedidosFiltrados = pedidos.pedidosFiltrados(filtro);
	}

	public StatusPedido[] getStatuses() {
		return StatusPedido.values();
	}

	// G&S
	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

	public void setPedidosFiltrados(List<Pedido> pedidosFiltrados) {
		this.pedidosFiltrados = pedidosFiltrados;
	}

	public ServicoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ServicoFilter filtro) {
		this.filtro = filtro;
	}

}
