package com.bb.controller.control.pesquisas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Pedidos;
import com.bb.controller.control.repository.filter.PedidoFilter;
import com.bb.models.Pedido;
import com.bb.models.Enumerators.StatusPedido;

@Named
@ViewScoped
public class PesquisaPedidoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;

	private List<Pedido> pedidosFiltrados;
	private PedidoFilter filtro;

	public PesquisaPedidoBean() {
		setPedidosFiltrados(new ArrayList<Pedido>());
		filtro = new PedidoFilter();

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

	public PedidoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(PedidoFilter filtro) {
		this.filtro = filtro;
	}

}
