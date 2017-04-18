package com.bb.controller.control.cadastros;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;

@Named
@ViewScoped
public class CadastroLiderDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Departamentos repositorioDepartamentos;
	private Departamento lider = new Departamento();
	private String departamento;
	
	private UploadedFile foto;
	 
   

	public void inicializar() {

		if(lider == null)		
		limpar();
	
}

	public CadastroLiderDepartamentoBean() {

		limpar();

	}

	

	public void cadastrar() {

		try {
			
			repositorioDepartamentos.guardar(this.lider);
			
			FacesUtil.addInforMessage("Líder "+ lider.getNome()+ " alterado com sucesso!");
			
			limpar();

		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());

		}
	}
	
	
	 public void handleFileUpload(FileUploadEvent event) {
		 
		 foto = event.getFile();
	        FacesUtil.addInforMessage("Sucesso! " + event.getFile().getFileName());
	    }

	 public String redirecionar(){
		 
		 lider = repositorioDepartamentos.porNomeGerente(departamento);
		 
		 System.out.println(">>>>>>>>>>>>>>  DEPARTAMENTO <<<<<<<<<<<<<<<<<< " + departamento);
		 
		 return"CadastroLiderDepartamento";
	 }
	 
	 //FacesContext.getCurrentInstance().getExternalContext().redirect("listar.xhtml");
	
	public void limpar() {

	 lider = new Departamento();

	}

	// G&S

	public Departamento getLider() {
		return lider;
	}

	public void setLider(Departamento lider) {
		this.lider = lider;

	}

	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}	
	
	

}
