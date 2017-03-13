package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

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
	
	private List<String> departamentosSource;
	private List<String> departamentosTarget;
	
	
	
	private boolean exibirPikeList = false;	
	private DualListModel<String> gerentes;


	public void inicializar() {	
		
		if (this.departamentoPosSave == null) {	
			
			limpar();
			
		}	
		
		exibirPikeList = isEditando();
		
//		if (this.departamentoPai.getCodigo()!= null){
//			isEditando();
//		}
				
		
				
		departamentosSource = repositorioDepartamentos.todosGerentesString();	
		departamentosTarget = new ArrayList<String>();	
		gerentes = new DualListModel<String>(departamentosSource, departamentosTarget);
	    
	}

	public CadastroDepartamentoBean() {
	
			limpar();		

	}
	
	
	public void cadastrar(){
		
		try {
			this.departamentoPai = repositorioDepartamentos.guardar(this.departamentoPosSave);
			FacesUtil.addInforMessage("Departamento " + departamentoPosSave.getNome() + " cadastrado com sucesso");
			limpar();
			
			
		}catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
			
		}		
	}
	
	public void cadastrarGerentes(){
		
		gerentesSelecionados = gerentes.getTarget();
		
		Departamento dep;
		
		if (!gerentesSelecionados.isEmpty()){
			for (String depo : gerentesSelecionados){
				
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
	
public boolean isEditando(){
	if (this.departamentoPai != null){				
			
			List<String> parcial = new ArrayList<>();
		
			for ( Departamento dep :departamentoPai.getGerentes()){	
				
				
				departamentosTarget.add(dep.getNome());
			}
//			departamentosTarget = parcial;
			
					
		return true;
	}
	
	return false;
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

	public DualListModel<String> getGerentes() {
		return gerentes;
	}

	public void setGerentes(DualListModel<String> gerentes) {
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

	public List<String> getDepartamentosSource() {
		return departamentosSource;
	}

	public void setDepartamentosSource(List<String> departamentosSource) {
		this.departamentosSource = departamentosSource;
	}

	public List<String> getDepartamentosTarget() {
		return departamentosTarget;
	}

	public void setDepartamentosTarget(List<String> departamentosTarget) {
		this.departamentosTarget = departamentosTarget;
	}

	
	
	
	

}
