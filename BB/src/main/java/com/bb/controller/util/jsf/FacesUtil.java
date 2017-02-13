package com.bb.controller.util.jsf;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

//Classe utilitária para tratar exceções para as telas JSF
public class FacesUtil {

	public static void addErrorMessage(String message) {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));

	}
	
	public static boolean isPostBack() {

		return FacesContext.getCurrentInstance().isPostback();
	}

	public static boolean notIsPostBack() {
		return !isPostBack();
	}
	

	public static void addInforMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));

	}
	
	public static void addInforProductSuccess(String produto, BigDecimal valor){
		
		String msg = "'produto " + produto + "' cadastrado com sucesso com o preço R$: "+  valor + "!"; 
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO, msg, msg));
		
	}



}
