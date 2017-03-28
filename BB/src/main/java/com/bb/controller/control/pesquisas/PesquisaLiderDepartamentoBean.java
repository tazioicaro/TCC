package com.bb.controller.control.pesquisas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;

@Named
@ViewScoped
public class PesquisaLiderDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Departamentos repositorioDepartamentos;
	
	

	private List<String> todosGerentes;
	private Departamento liderSelecionado;
	

	
	
	public void excluir(){
		
		try{
			repositorioDepartamentos.removerDepartamento(liderSelecionado);
			
			FacesUtil.addInforMessage("Lider "+liderSelecionado.getNome()+" removido com sucesso!");
		}catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
		}
		
	}
	
	
	
	public PesquisaLiderDepartamentoBean(){	
	
		todosGerentes = new ArrayList<>();
		
	
	}	
	
	@PostConstruct
	public void init(){
		todosGerentes = repositorioDepartamentos.todosGerentesString();
	}
	
	
	//G&S
	public Departamento getLiderSelecionado() {
		return liderSelecionado;
	}
	public void setLiderSelecionado(Departamento liderSelecionado) {
		this.liderSelecionado = liderSelecionado;
	}



	public List<String> getTodosGerentes() {
		return todosGerentes;
	}



	public void setTodosGerentes(List<String> todosGerentes) {
		this.todosGerentes = todosGerentes;
	}

}
