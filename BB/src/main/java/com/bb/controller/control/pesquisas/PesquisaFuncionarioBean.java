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
import com.bb.controller.control.repository.Funcionarios;
import com.bb.controller.control.repository.Grupos;
import com.bb.controller.control.repository.filter.FuncionarioFilter;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;
import com.bb.models.Funcionario;
import com.bb.models.Grupo;

@Named	
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios repositorioFuncionario;	
	@Inject
	private Grupos repositorioGrupos;	
	@Inject
	private Departamentos repositorioDepartamento;
	
	
	private FuncionarioFilter filtro;
	private Funcionario FuncionarioSelecionado;
	private LazyDataModel<Funcionario> model;
	
	public PesquisaFuncionarioBean(){
		
		filtro = new FuncionarioFilter();
		
		model = new LazyDataModel<Funcionario>(){

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Funcionario> load(int first, int pageSize, 
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				
				filtro.setPrimeiroRegistro(first);
				filtro.setQtdeRequistros(pageSize);
				filtro.setPropriedadeOrdenacao(sortField);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				
				setRowCount(repositorioFuncionario.quantidadeFiltrados(filtro));
				
				return repositorioFuncionario.filtrados(filtro);
			}
			
			
		};
		
	}
	
	
	public List<Grupo> getListGrupo(){
		return repositorioGrupos.porGrupos();
	}
	
	public List<Departamento> getListDepartamento(){
		return repositorioDepartamento.porDepartamento();
	}
	
	public void excluir(){
		
		try{repositorioFuncionario.remover(FuncionarioSelecionado);
		FacesUtil.addInforMessage("Funcionário " + FuncionarioSelecionado.getNome() + " excluído com sucesso!");
		} catch(NegocioException ne){
			
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	

	public FuncionarioFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(FuncionarioFilter filtro) {
		this.filtro = filtro;
	}

	public Funcionario getFuncionarioSelecionado() {
		return FuncionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		FuncionarioSelecionado = funcionarioSelecionado;
	}

	public LazyDataModel<Funcionario> getModel() {
		return model;
	}

	public void setModel(LazyDataModel<Funcionario> model) {
		this.model = model;
	}
	
	
	
	

}
