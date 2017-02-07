package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.bb.controller.control.repository.Clientes;
import com.bb.models.Cliente;

@FacesConverter(forClass= Cliente.class)
public class ClienteConverter implements Converter{
	
	@Inject
	private Clientes clientes;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

    Cliente retorno = null;
    
    if (value != null){
    	
    	Long codigo = new Long(value);
    	
    	retorno = clientes.porId(codigo); 
    }
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

if (value != null){
	
	Cliente cliente = (Cliente) value;
	
	return cliente.getCodigo()== null ? null : cliente.getCodigo().toString();
}
		return "";
	}

}
