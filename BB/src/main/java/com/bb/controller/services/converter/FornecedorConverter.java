package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bb.controller.control.repository.FornecedorRepository;
import com.bb.controller.util.cdi.CDIServiceLocator;
import com.bb.models.Fornecedor;

@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConverter implements Converter {

	private FornecedorRepository fornecedorRp;

	public FornecedorConverter() {
		fornecedorRp = CDIServiceLocator.getBean(FornecedorRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {

		Fornecedor retorno = null;

		if (value != null) {

			Long codigo = new Long(value);

			retorno = fornecedorRp.porCodigo(codigo);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {			
			return ((Fornecedor) value).getCodigo().toString();
		}
		return null;
	}

}
