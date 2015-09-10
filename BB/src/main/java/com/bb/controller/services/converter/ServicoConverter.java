package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bb.controller.control.repository.Produtos;
import com.bb.controller.control.repository.Servicos;
import com.bb.controller.util.cdi.CDIServiceLocator;
import com.bb.models.Produto;
import com.bb.models.Servico;

@FacesConverter(forClass = Produto.class)
public class ServicoConverter implements Converter {

	//@Inject
	private Servicos servicos;

	public ServicoConverter() {
		servicos = CDIServiceLocator.getBean(Servicos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {

		Servico servico = null;

		if (value != null) {

			Long codigo = new Long(value);

			retorno = servicos.porCodigo(codigo);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if( value !=null){
			Servico servico = (Servico) value;				
			return servico.getCodigo() == null ? null :servico.getCodigo().toString();
		}
		return "";
	}

}
