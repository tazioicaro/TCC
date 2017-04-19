package com.bb.controller.control.cadastros;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	private Departamento gerente;
	private List<Departamento> gerentesEdicao;
	
	private String gerenteSelecionadoString;

	
/*	private UploadedFile foto;*/
	 
   
	public CadastroLiderDepartamentoBean() {
		
		if(gerenteSelecionadoString == null){
		limpar();
		}

	}
	

	public void inicializar() {	
		

		if(gerente == null )	{
			limpar();
			}		
 
	
}

	

	

	public void cadastrar() {

		try {
			
			repositorioDepartamentos.guardar(this.gerente);
			
			FacesUtil.addInforMessage("Líder "+ gerente.getNome()+ " alterado com sucesso!");
			
			limpar();
			/*gerenteSelecionadoString = null;
			gerentesEdicao.clear();*/

		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());

		}
	}
	
	
	/* public void handleFileUpload(FileUploadEvent event) {
		 
		 foto = event.getFile();
	        FacesUtil.addInforMessage("Sucesso! " + event.getFile().getFileName());
	    }*/

		 
	
	public void limpar() {

		gerente = new Departamento();

	}
	
	
	
	
	public void redirecionar() {		
		gerentesEdicao = repositorioDepartamentos.porNomeGerente(gerenteSelecionadoString);		
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
	
	

	// G&S

	public Departamento getGerente() {
		return gerente;
	}

	public void setGerente(Departamento gerente) {
		this.gerente = gerente;

	}

//	public UploadedFile getFoto() {
//		return foto;
//	}
//
//	public UploadedFile getFoto() {
//		return foto;
//	}

	/*public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}*/

	public String getGerenteSelecionadoString() {
		return gerenteSelecionadoString;
	}

	public void setGerenteSelecionadoString(String gerenteSelecionadoString) {
		this.gerenteSelecionadoString = gerenteSelecionadoString;
	}
	

	public List<Departamento> getGerentesEdicao() {
		return gerentesEdicao;
	}

	public void setGerentesEdicao(List<Departamento> gerentesEdicao) {
		this.gerentesEdicao = gerentesEdicao;
	}
	

}
