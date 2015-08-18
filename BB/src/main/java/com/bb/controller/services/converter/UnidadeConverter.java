package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bb.controller.control.repository.UnidadesMedidas;
import com.bb.controller.util.cdi.CDIServiceLocator;
import com.bb.models.Unidade;

@FacesConverter(forClass = Unidade.class)
public class UnidadeConverter implements Converter {

	private UnidadesMedidas unidades;

	public UnidadeConverter() {
		unidades = CDIServiceLocator.getBean(UnidadesMedidas.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Unidade retorno = null;

		if (value != null) {

			Long codigo = new Long(value);

			retorno = unidades.porCodigo(codigo);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			
			return ((Unidade) value).getCodigo().toString();

		}
		return null;
	}

}
