package com.bb.controller.control.pesquisas;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.cadastros.CadastroLiderDepartamentoBean;
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
	private String liderSelecionadoString;	
	private Departamento liderSelecionado;
	private String gerente;	
	
	private CadastroLiderDepartamentoBean cadastro;


	
	
	public void excluir(){
		
		try{		
			liderSelecionado.setNome(liderSelecionadoString);
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
	
	

	public void redirecionar() {		
		gerentesEdicao = repositorioDepartamentos.porNomeGerente(gerente.getNome());		
		gerente = gerentesEdicao.get(0);
			 
//			 System.out.println(">>>>>>>>>>>>>>  DEPARTAMENTO <<<<<<<<<<<<<<<<<< " + gerente.getNome());
			 
			 try {					 
					      
//				 FacesContext.getCurrentInstance().getExternalContext().getFlash()
//	                .put("gerente", gerente);
				FacesContext.getCurrentInstance().getExternalContext().redirect("CadastroLiderDepartamento.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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



	public String getLiderSelecionadoString() {
		return liderSelecionadoString;
	}



	public void setLiderSelecionadoString(String liderSelecionadoString) {
		this.liderSelecionadoString = liderSelecionadoString;
	}



	public String getGerente() {
		return gerente;
	}



	public void setGerente(String gerente) {
		this.gerente = gerente;
	}



	public CadastroLiderDepartamentoBean getCadastro() {
		return cadastro;
	}



	public void setCadastro(CadastroLiderDepartamentoBean cadastro) {
		this.cadastro = cadastro;
	}


}
