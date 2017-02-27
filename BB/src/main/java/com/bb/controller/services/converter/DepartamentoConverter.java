package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.bb.controller.control.repository.Departamentos;
import com.bb.models.Departamento;

@FacesConverter(forClass = Departamento.class)
public class DepartamentoConverter implements Converter {

	@Inject
	private Departamentos departamentos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Departamento retorno = null;

		if (StringUtils.isNoneEmpty(value)) {

			Long codigo = new Long(value);
			retorno = this.departamentos.porId(codigo);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Departamento departamento = (Departamento) value;

			return departamento.getCodigo() == null ? null : departamento.getCodigo().toString();
		}
		return "";
	}

}
