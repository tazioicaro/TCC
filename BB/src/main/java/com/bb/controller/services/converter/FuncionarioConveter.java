package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.bb.controller.control.repository.Funcionarios;
import com.bb.models.Funcionario;

@FacesConverter(forClass=Funcionario.class)
public class FuncionarioConveter implements Converter {
	
	@Inject
	private Funcionarios repositorioFuncionario;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Funcionario retorno = null;
	      
	      if(StringUtils.isNotEmpty(value)){
	    	  
	    	  Long codigo = new Long( value);
	    	  
	    	  retorno = repositorioFuncionario.porID(codigo);
	      }
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value !=null){
			
			Funcionario funcionario = (Funcionario) value;
			
			return funcionario.getCodigo() == null ? null : funcionario.getCodigo().toString();			
			
		}
      
		return "";
	}

}
