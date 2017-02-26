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
import com.bb.models.Departamento;

@Named
@ViewScoped
public class CadastroDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Departamento departamento;
	
	@Inject
	private Departamentos repositorioDepartamentos;
	
	 private DualListModel<Departamento> gerentes;
	 private Departamento NovosGerentes;
	 
	 
	 public void inicializar(){
		 limpar();
	 }
	
	 private void CasdastroDepartamentoBean() {
		 
		 limpar();
		

	}
	 
	 
	 public void cadastrar(){
		 
	 }

   public void limpar(){
	   
	   List<Departamento> departamentosSource = repositorioDepartamentos.porDepartamento()  ;
	     List<Departamento> departamentosTarget = new ArrayList<Departamento>();
	     gerentes = new DualListModel<Departamento>(departamentosSource, departamentosTarget);
	   
   }

	
	
	
	
	
	 public void onTransfer(TransferEvent event) {
	        StringBuilder builder = new StringBuilder();
	        for(Object item : event.getItems()) {
	            builder.append(((Departamento) item).getNome()).append("<br />");
	        }
	         
	        FacesMessage msg = new FacesMessage();
	        msg.setSeverity(FacesMessage.SEVERITY_INFO);
	        msg.setSummary("Items Trasnferidos");
	        msg.setDetail(builder.toString());
	         
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    } 
	 
	    public void onSelect(SelectEvent event) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gerente Selecionado", event.getObject().toString()));
	    }
	     
	    public void onUnselect(UnselectEvent event) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gerente removido", event.getObject().toString()));
	    }
	     
	    public void onReorder() {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Lista reogarnizada", null));
	    }
	    
	    

		public DualListModel<Departamento> getGerentes() {
			return gerentes;
		}

		public void setGerentes(DualListModel<Departamento> gerentes) {
			this.gerentes = gerentes;
		} 
	
		public Departamento getDepartamento() {
			return departamento;
		}

		public void setDepartamento(Departamento departamento) {
			this.departamento = departamento;
		}



		public Departamento getNovosGerentes() {
			return NovosGerentes;
		}



		public void setNovosGerentes(Departamento novosGerentes) {
			NovosGerentes = novosGerentes;
		}
	    
	    
	    

}
