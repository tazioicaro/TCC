package com.bb.controller.control.pesquisas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.control.repository.filter.DepartamentoFilter;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;

@Named
@ViewScoped
public class PesquisaLiderDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Departamentos repositorioDepartamentos;
	
	
	private LazyDataModel<Departamento> model;
	private Departamento liderSelecionado;
	
	private DepartamentoFilter filtro;
	
	
	public void excluir(){
		
		try{
			repositorioDepartamentos.removerDepartamento(liderSelecionado);
			
			FacesUtil.addInforMessage("Lider "+liderSelecionado.getNome()+" removido com sucesso!");
		}catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
		}
		
	}
	
	
	
	public PesquisaLiderDepartamentoBean(){
		
		filtro = new DepartamentoFilter();
		
		model = new LazyDataModel<Departamento>(){			
			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Departamento> load(int first, int pageSize, 
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

                         filtro.setPrimeiroRegistro(first);
                         filtro.setQuantidadeRegistros(pageSize);
                         filtro.setPropriedadeOrdenacao(sortField);
                         filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));                         
                         setRowCount(repositorioDepartamentos.quantidadeFiltradosGerentes(filtro));				
				
				return repositorioDepartamentos.filtradosGerentes(filtro);
			}
			
		};
	}	
	
	//G&S
	public Departamento getLiderSelecionado() {
		return liderSelecionado;
	}
	public void setLiderSelecionado(Departamento liderSelecionado) {
		this.liderSelecionado = liderSelecionado;
	}
	public LazyDataModel<Departamento> getModel() {
		return model;
	}
	public void setModel(LazyDataModel<Departamento> model) {
		this.model = model;
	}
	public DepartamentoFilter getFiltro() {
		return filtro;
	}
	public void setFiltro(DepartamentoFilter filtro) {
		this.filtro = filtro;
	}

}
