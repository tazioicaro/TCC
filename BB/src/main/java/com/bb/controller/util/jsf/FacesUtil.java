package com.bb.controller.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

//Classe utilitária para tratar exceções para as telas JSF
public class FacesUtil {
	
	public static void addErrorMessage(String message){
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				message, message));
		
	}

}
