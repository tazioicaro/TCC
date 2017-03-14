package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;

@Named
@ViewScoped
public class CadastroDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Departamentos repositorioDepartamentos;

	private Departamento departamentoPai = new Departamento();
	private Departamento departamentoPosSave;
	private List<String> gerentesSelecionados;
	
	//teste
	private Departamento getente;
	
		
	private boolean exibirPikeList = false;	
	
	private List<String> gerentes = new ArrayList<String>();
	private List<String> gerentesConvert = new ArrayList<>();


	public void inicializar() {	
		
		if (departamentoPai.getCodigo()!= null) {
			edicaoGerentes();
					}
		
		obterGerentes();
		
		
	    
	}

	public CadastroDepartamentoBean() {
	
			limpar();		

	}
	
	List<String> obterGerentes() {
		return this.gerentes = repositorioDepartamentos.todosGerentesString();
	}
	
	
	
	public void cadastrar(){
		
		try {
			this.departamentoPai = repositorioDepartamentos.guardar(this.departamentoPosSave);
			FacesUtil.addInforMessage("Departamento " + departamentoPosSave.getNome() + " cadastrado com sucesso");
			limpar();
			obterGerentes();
			
			
		}catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
			
		}		
	}
	
	
	public void cadastrarGerentes(){	
		
		Departamento dep;
		
		if (!gerentesConvert.isEmpty()){
			for (String depo : gerentesConvert){
				
				dep = new Departamento();
				
				dep.setDepartamentoPai(departamentoPai);
				dep.setNome(depo);
				
			
				repositorioDepartamentos.guardar(dep);
			}			
			
			FacesUtil.addInforMessage("Líder(es) cadastrado(s) com sucesso");			
		
		}	
	
	}	
	


	public void limpar() {	

		departamentoPosSave = new Departamento();		

	}
	
	
	public void edicaoGerentes(){		
			
			for ( Departamento dep : departamentoPai.getGerentes()){	
				
				gerentesConvert.add(dep.getNome());
			
		}
		
	}

	
	public void alterarExibirPikeList(){
		exibirPikeList = true;
		
	}	
	

	public void onTransfer(TransferEvent event) {

    } 
 
    public void onSelect(SelectEvent event) {

    }
     
    public void onUnselect(UnselectEvent event) {

    }
     
    public void onReorder() {
    } 

	// G&S

	public Departamento getDepartamentoPai() {
		return departamentoPai;
	}

	public void setDepartamentoPai(Departamento departamentoPai) {
		this.departamentoPai = departamentoPai;	
		
	}	

	public List<String> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<String> gerentes) {
		this.gerentes = gerentes;
	}

	public boolean isExibirPikeList() {
		return exibirPikeList;
	}

	public void setExibirPikeList(boolean exibirPikeList) {
		this.exibirPikeList = exibirPikeList;
	}

	public Departamento getDepartamentoPosSave() {
		return departamentoPosSave;
	}

	public void setDepartamentoPosSave(Departamento departamentoPosSave) {
		this.departamentoPosSave = departamentoPosSave;
	}

	public List<String> getGerentesSelecionados() {
		return gerentesSelecionados;
	}

	public void setGerentesSelecionados(List<String> gerentesSelecionados) {
		this.gerentesSelecionados = gerentesSelecionados;
	}

	public Departamento getGetente() {
		return getente;
	}

	public void setGetente(Departamento getente) {
		this.getente = getente;
	}
	

	public List<String> getGerentesConvert() {
		return gerentesConvert;
	}

	public void setGerentesConvert(List<String> gerentesConvert) {
		this.gerentesConvert = gerentesConvert;
	}

	
	
	
	

}
