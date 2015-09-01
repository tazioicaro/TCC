package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bb.controller.control.repository.Especialidades;
import com.bb.controller.util.cdi.CDIServiceLocator;
import com.bb.models.Especialidade;

@FacesConverter(forClass=Especialidade.class)
public class EspecialidadeConverter implements Converter {

	//@Inject Verificar na versão Mojarra 2.3 pronta o funcionamento do  Inject
	private Especialidades especialidades;
	
	//Para driblar a falta do Inject
	public EspecialidadeConverter() {
		especialidades = CDIServiceLocator.getBean(Especialidades.class);
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
		
		Especialidade especialidade = (Especialidade) value;				
		return especialidade.getCodigo() == null ? null :especialidade.getCodigo().toString();
		
		
	}
		return "";
	}
}
