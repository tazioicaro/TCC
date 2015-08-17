package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;




import com.bb.controller.control.repository.Especialidades;
import com.bb.controller.util.cdi.CDIServiceLocator;
import com.bb.models.Especialidade;

public class EspecialidadeConverter implements Converter {

	//@Inject Verificar na versão Mojarra 2.3 pronta o funcionamento do  Inject
	private Especialidades especialidades;
	
	//Para driblar a falta do Inject
	public EspecialidadeConverter() {
		especialidades = CDIServiceLocator.gerBean(Especialidades.class);
	}
	
	
	//Trabalhando com ID como referencia
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Especialidade retorno = null;
		
         if(value != null){
        	 
        	 Long codigo = new Long(value);
        	 retorno =  especialidades.porCodigo(codigo);
         }
		return retorno;
	}

	
	//Recebe Objeto e retorna String
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
	if(value != null){
		return ((Especialidade) value).getCodigo().toString();
	}
		return null;
	}
}
