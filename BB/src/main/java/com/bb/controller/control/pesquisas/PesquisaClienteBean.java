package com.bb.controller.control.pesquisas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.bb.controller.control.repository.Clientes;
import com.bb.controller.control.repository.filter.ClienteFilter;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Cliente;

@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Inject
	private Clientes clientes;
	
	private LazyDataModel<Cliente> model;
	private Cliente clienteSelecionado;
	private ClienteFilter filter;
	
	
	public PesquisaClienteBean(){
		
		filter = new ClienteFilter();
		
		model = new LazyDataModel<Cliente>(){			
			private static final long serialVersionUID = 1L;
			
			public List<Cliente> load(int first, int pageSize, String sortField,
					SortOrder sortOrder, Map<String, Object> filters){
				
				filter.setPrimeiroRegistro(first);
				filter.setQuantidadeRegistros(pageSize);
				filter.setPropriedadeOrdenacao(sortField);
				filter.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				
				setRowCount(clientes.quantidadeFiltrados(filter));
				
				return clientes.filtrados(filter);
			}
			
		};
	}
	
	public void excluir(){
		try{
		clientes.removerCliente(clienteSelecionado);
		FacesUtil.addInforMessage("O cliente " + clienteSelecionado.getNome() + " foi excluído com sucesso!");		
		}catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	
	//G&S
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	public ClienteFilter getFilter() {
		return filter;
	}
	public void setFilter(ClienteFilter filter) {
		this.filter = filter;
	}
	public LazyDataModel<Cliente> getModel() {
		return model;
	} 
	
}
